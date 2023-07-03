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
using Tetris2.Forms.HelpForms;

namespace Tetris2.Forms.User
{
    public partial class StatisticsForm : Form
    {
        private string level_id;
        private PlayerMainForm pmf;
        public StatisticsForm(string _level_id, PlayerMainForm _pmf)
        {
            level_id = _level_id;
            pmf = _pmf;
            InitializeComponent();
            cbGameMode.SelectedIndex = 0;
            showTimeMode();
        }

        private void cbGameMode_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (cbGameMode.SelectedIndex == 0)
            {
                dgvStatistics.Columns[1].HeaderText = "Время";
                showTimeMode();
            }
            else
            {
                dgvStatistics.Columns[1].HeaderText = "Очки";
                showPointsMode();
            }
        }

        private void showTimeMode()
        {
            dgvStatistics.Rows.Clear();
            SQLConnect sql = new SQLConnect();
            DataTable dt = sql.getData("select stat_time, login"
                + " from statistic inner join user_tb"
                + " on statistic.user_id = user_tb.user_id"
                + " where statistic.level_id = " + level_id
                + " and statistic.stat_time<>0 order by stat_time desc fetch first 10 rows only");
            for(int i = 0; i < dt.Rows.Count; ++i)
            {
                string[] args = new string[2];
                args[0] = dt.Rows[i].ItemArray[1].ToString();
                args[1] = String.Format("{0:HH:mm:ss:ff}", new DateTime().AddTicks(long.Parse(dt.Rows[i].ItemArray[0].ToString())));
                dgvStatistics.Rows.Add(args);
            }
        }

        private void showPointsMode()
        {
            dgvStatistics.Rows.Clear();
            SQLConnect sql = new SQLConnect();
            DataTable dt = sql.getData("select points, login"
                + " from statistic inner join user_tb"
                + " on statistic.user_id = user_tb.user_id"
                + " where statistic.level_id = " + level_id
                + " and statistic.points<>0 order by points desc fetch first 10 rows only");
            for (int i = 0; i < dt.Rows.Count; ++i)
            {
                string[] args = new string[2];
                args[0] = dt.Rows[i].ItemArray[1].ToString();
                args[1] = dt.Rows[i].ItemArray[0].ToString();
                dgvStatistics.Rows.Add(args);
            }
        }
        private void btnMenu_Click(object sender, EventArgs e)
        {
            pmf.Show();
            pmf.Location = new Point(this.Location.X, this.Location.Y);
            this.Dispose();
        }

        private void StatisticsForm_FormClosing(object sender, FormClosingEventArgs e)
        {
            Application.Exit();
        }

        private void btn_question_Click(object sender, EventArgs e)
        {
           
        }

        private void btn_inquiry_Click(object sender, EventArgs e)
        {
            new AboutDevelopersForm().ShowDialog();
        }
    }
}
