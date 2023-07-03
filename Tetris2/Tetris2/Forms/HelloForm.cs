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

namespace Tetris2
{
    public partial class HelloForm : Form
    {
        public HelloForm()
        {
            InitializeComponent();
            this.CenterToScreen();
        }

        private void btn_ToComeIn_Click(object sender, EventArgs e)
        {
            if (!isCorrect()) return;

            string id;
            if (isAdmin())
            {
                this.Hide();
                AdminMainForm amf = new AdminMainForm(this);
                amf.Show();
                amf.Location = new Point(this.Location.X, this.Location.Y);
                tb_login.Text = "";
                tb_password.Text = "";
                tb_login.BackColor = Color.White;
                tb_password.BackColor = Color.White;
            }
            else if ((id = isUserExist()) != "-1")
            {
                this.Hide();
                PlayerMainForm pmf = new PlayerMainForm(id, this);
                pmf.Bounds = this.Bounds;
                pmf.Show();
                pmf.Location = new Point(this.Location.X, this.Location.Y);
                tb_login.Text = "";
                tb_password.Text = "";
                tb_login.BackColor = Color.White;
                tb_password.BackColor = Color.White;
            }
        }
        private bool isCorrect()
        {
            if (tb_login.Text.Length > 32 || tb_login.Text.Length < 2)
            {
                tb_login.BackColor = Color.Yellow;
                return false;
            }
            tb_login.BackColor = Color.White;

            if (tb_password.Text.Length > 32)
            {
                tb_password.BackColor = Color.Yellow;
                return false;
            }
            tb_password.BackColor = Color.White;
            return true;

        }
        private bool isAdmin()
        {
            if (tb_login.Text == "Admin" && tb_password.Text == "Password") return true;
            return false;
        }

        private string isUserExist()
        {
            SQLConnect sql = new SQLConnect();
            DataTable dt = sql.getData("select users_password, user_id from user_tb where login='" + tb_login.Text + "'");
            if (dt.Rows.Count != 1)
            {
                tb_login.BackColor = Color.Yellow;
                return "-1";
            }
            tb_login.BackColor = Color.White;

            if (dt.Rows[0].ItemArray[0].ToString() != tb_password.Text
                    && dt.Rows[0].ItemArray[0].ToString().Length != 0)
            {
                tb_password.BackColor = Color.Yellow;
                return "-1";
            }
            tb_password.BackColor = Color.White;
            return dt.Rows[0].ItemArray[1].ToString();
        }

        private void btn_Registration_Click(object sender, EventArgs e)
        {
            this.Hide();
            RegistrationForm rf = new RegistrationForm(this);
            rf.Show();
            rf.Location = new Point(this.Location.X, this.Location.Y);
            tb_login.Text = "";
            tb_password.Text = "";
            tb_login.BackColor = Color.White;
            tb_password.BackColor = Color.White;
        }

        private void HelloForm_FormClosing(object sender, FormClosingEventArgs e)
        {
            Application.Exit();
        }

        private void btn_question_Click(object sender, EventArgs e)
        {
            new HelpHelloForm().ShowDialog();
        }

        private void btn_inquiry_Click(object sender, EventArgs e)
        {
            new AboutDevelopersForm().ShowDialog();
        }
    }
}
