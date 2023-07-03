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
    public partial class RegistrationForm : Form
    {
        private HelloForm hf;
        public RegistrationForm(HelloForm Hf)
        {
            hf = Hf;
            InitializeComponent();
        }

        private void btnRegistration_Click(object sender, EventArgs e)
        {
            if (isCorrect() && isUnique())
            {

                SQLConnect sql = new SQLConnect();
                DataTable dt = sql.getData("select user_id from user_tb");
                int user_id = 0;
                while (true)
                {
                    ++user_id;
                    if (isUniqueId(user_id, dt))
                        break;
                }
                sql.setData("insert into user_tb values (" + user_id.ToString() + ", '" + tb_login.Text + "', '" + tb_password.Text + "')");
                hf.Show();
                hf.Location = new Point(this.Location.X, this.Location.Y);
                this.Dispose();
            }
        }
        private bool isCorrect()
        {
            if(tb_login.Text.Length < 2 || tb_login.Text.Length > 32)
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

            if (tb_passwordAgain.Text.Length > 32 || tb_password.Text != tb_passwordAgain.Text)
            {
                tb_passwordAgain.BackColor = Color.Yellow;
                return false;
            }
            tb_passwordAgain.BackColor = Color.White;
            return true;
        }
        private bool isUnique()
        {
            SQLConnect sql = new SQLConnect();
            DataTable dt = sql.getData("select * from user_tb where login='" + tb_login.Text + "'");
            if (dt.Rows.Count != 0)
            {
                tb_login.BackColor = Color.Yellow;
                return false;
            }
            tb_login.BackColor = Color.White;
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

        private void btnGoBack_Click(object sender, EventArgs e)
        {
            hf.Show();
            hf.Location = new Point(this.Location.X, this.Location.Y);
            this.Dispose();
        }

        private void RegistrationForm_FormClosing(object sender, FormClosingEventArgs e)
        {
            Application.Exit();
        }

        private void btn_question_Click(object sender, EventArgs e)
        {
            new HelpRegistrationForm().ShowDialog();
        }

        private void btn_inquiry_Click(object sender, EventArgs e)
        {
            new AboutDevelopersForm().ShowDialog();
        }
    }
}
