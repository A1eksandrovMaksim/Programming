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
    public partial class BeforeStartGameForm : Form
    {
        private int i = 3;
        private WindowsMediaPlayer wmp;
        private DateTime timeOfLastTick;
        private Timer timer1;
        private string pathResources = @"C:\Users\Admin\Desktop\Home work\6403\7 семестр\ТПИВС\Tetris2\Tetris2\Resources\";

        private Level level;
        private bool netMode;
        private string gameMode;
        private string user_id;
        private int effectVolume;
        private int backgroundValume;
        private string topScore;
        private PlayerMainForm pmf;

        
        public BeforeStartGameForm(Level _level, bool _netMode, string _gameMode,
            string _user_id, string _topScore, int _effectVolume, int _backgroundValume, PlayerMainForm _pmf)
        {
            InitializeComponent();
            timer1 = new Timer();
            timer1.Interval = 10;
            timer1.Tick += new EventHandler(update);
            timeOfLastTick = DateTime.Now;
            wmp = new WindowsMediaPlayer();
            wmp.settings.volume = 0;
            wmp.URL = pathResources + "Countdown.mp3";

            level = _level;
            netMode = _netMode;
            gameMode = _gameMode;
            user_id = _user_id;
            topScore = _topScore;
            effectVolume = _effectVolume;
            backgroundValume = _backgroundValume;
            pmf = _pmf;

        }

        private void update(object sender, EventArgs e)
        {
            if ((DateTime.Now.Ticks - timeOfLastTick.Ticks) / 10000000.0 > 1)
            {
                timeOfLastTick = DateTime.Now;
                if (i > 0)
                {
                    lbCountdown.Visible = true;
                    wmp.controls.stop();
                    wmp.controls.play();
                    lbCountdown.Text = i.ToString();
                    --i;
                }
                else
                {
                    timer1.Stop();
                    wmp.controls.stop();
                    MainGameForm mgf = new MainGameForm(level, netMode, gameMode,
                        user_id, topScore, effectVolume, backgroundValume, pmf);
                    mgf.Show();
                    mgf.Location = new Point(this.Location.X, this.Location.Y);
                    this.Dispose();
                }
            }
        }

        private void lbCountdown_Click(object sender, EventArgs e)
        {
            wmp.settings.volume = effectVolume;
            timer1.Start();
        }

        private void btnGoHome_Click(object sender, EventArgs e)
        {
            timer1.Stop();
            wmp.controls.stop();
            pmf.Show();
            pmf.Location = new Point(this.Location.X, this.Location.Y);
            this.Dispose();
        }
    }
}
