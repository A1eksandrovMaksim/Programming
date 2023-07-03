using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using Tetris2.Classes;
using WMPLib;

namespace Tetris2.Forms.User
{
    public partial class TheEndOfGameForm : Form
    {
        private long score;
        private long time;
        private string user_id;
        private WindowsMediaPlayer wmp;
        private PlayerMainForm pmf;
        private string pathResources = @"C:\Users\Admin\Desktop\Home work\6403\7 семестр\ТПИВС\Tetris2\Tetris2\Resources\";
        public TheEndOfGameForm(string GameMode, long _time,
            long _score, int lines, int blocks, int level,
            string _user_id, int _effectVolume, string level_id,
            PlayerMainForm _pmf)
        {
            InitializeComponent();

            wmp = new WindowsMediaPlayer();
            wmp.settings.volume = _effectVolume;
            wmp.URL = pathResources + "loss.mp3";
            score = _score;
            time = _time;
            pmf = _pmf;
            user_id = _user_id;

            lbLines.Text = lines.ToString();
            lbScore.Text = score.ToString();
            lbBlocks.Text = blocks.ToString();
            lbLevel.Text = level.ToString();
            lbTime.Text = String.Format("{0:HH:mm:ss:ff}", new DateTime().AddTicks(time));

            SQLConnect sql = new SQLConnect();
            DataTable dt = sql.getData("select statistic_id, points, stat_time from statistic");
            int stat_id = 0;
            while (true)
            {
                ++stat_id;
                if (isUniqueId(stat_id, dt))
                    break;
            }

            string sqlQeury = "";
            sqlQeury += "insert into statistic values (" + stat_id.ToString() + ", ";

            if (GameMode == "Time" || GameMode == "Both")
                sqlQeury += time.ToString();
            else
                sqlQeury += "0";

            if (GameMode == "Points" || GameMode == "Both")
                sqlQeury += ", " + score.ToString();
            else
                sqlQeury += ", 0";

            sqlQeury += ", " + user_id + ", " + level_id + ")";

            if(GameMode != "Free")
                sql.setData(sqlQeury);

            sql.setData("delete from statistic where statistic_id " +
                "not in (select statistic_id from statistic order by " +
                    "stat_time desc fetch first 10 rows only) and statistic_id " +
                "not in (select statistic_id from statistic order by " +
                    "points desc fetch first 10 rows only)");

            if (isMaxPoints(score, dt) && (GameMode == "Points" || GameMode == "Both"))
                {
                wmp.URL = pathResources + "success.mp3";
                lbBestScore.Visible = true;
            }
            if (isMaxTime(time, dt) && (GameMode == "Both" || GameMode == "Time"))
            {
                wmp.URL = pathResources + "success.mp3";
                lbBestTime.Visible = true;
            }

            wmp.controls.play();
        }

        private bool isMaxPoints(long currnentvalue, DataTable tb)
        {
            for (int i = 0; i < tb.Rows.Count; ++i)
            {
                if (currnentvalue <= long.Parse(tb.Rows[i].ItemArray[1].ToString()))
                    return false;
            }
            return true;
        }
        private bool isMaxTime(long currnentvalue, DataTable tb)
        {
            for (int i = 0; i < tb.Rows.Count; ++i)
            {
                if (currnentvalue <= long.Parse(tb.Rows[i].ItemArray[2].ToString()))
                    return false;
            }
            return true;
        }

        private bool isUniqueId(int id, DataTable ids)
        {
            for (int i = 0; i < ids.Rows.Count; ++i)
            {
                if (id == int.Parse(ids.Rows[i].ItemArray[0].ToString()))
                    return false;
            }
            return true;
        }
        private void btnOk_Click(object sender, EventArgs e)
        {
            wmp.controls.stop();
            pmf.Show();
            pmf.Location = new Point(this.Location.X, this.Location.Y);
            GC.Collect();
            this.Dispose();
        }

        private void TheEndOfGameForm_FormClosing(object sender, FormClosingEventArgs e)
        {
            Application.Exit();
        }
    }
}
