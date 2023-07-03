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

namespace Tetris2.Forms.Admin.Editors
{
    public partial class UserEditorForm : Form
    {
        private UserClass user;
        private UsersEditorForm uef;
        public UserEditorForm(UserClass _user, UsersEditorForm _uef)
        {
            InitializeComponent();
            user = _user;
            uef = _uef;
            tb_login.Text = user.getLogin();
            tb_password.Text = user.getPassword();
        }

        private void btnGoHome_Click(object sender, EventArgs e)
        {
            uef.Show();
            uef.Location = new Point(this.Location.X, this.Location.Y);
            uef.showUsers();
            this.Dispose();
        }
        private bool isCorrect()
        {
            if (tb_login.Text.Length < 2 || tb_login.Text.Length > 32)
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

        private bool isNewUser()
        {
            SQLConnect sql = new SQLConnect();
            if (sql.getData("select * from user_tb where user_id=" + user.getUserID().ToString()).Rows.Count == 0)
                return true;
            else
                return false;
        }

        private bool isUnique(string login)
        {
            SQLConnect sql = new SQLConnect();
            if (sql.getData("select * from user_tb where login='" + user.getLogin()+"'").Rows.Count == 0)
                return true;
            else
                return false;
        }

        private void btnSavingUser_Click(object sender, EventArgs e)
        {
            if(isCorrect())
            {
                SQLConnect sql = new SQLConnect();
                if (isNewUser())
                {
                    if (!isUnique(tb_login.Text))
                    {
                        tb_login.BackColor = Color.Yellow;
                        tb_login.Text = user.getLogin();
                        return;
                    }
                    sql.setData("insert into user_tb values" +
                        " (" + user.getUserID().ToString()
                        + ", '" + tb_login.Text
                        + "', '" + tb_password.Text
                        + "')");
                }
                else
                {
                    sql.setData("update user_tb set login=" +
                        "'" + tb_login.Text + "', users_password='" +
                        tb_password.Text + "' where user_id=" +
                        user.getUserID().ToString());
                }
                uef.Show();
                uef.Location = new Point(this.Location.X, this.Location.Y);
                uef.showUsers();
                this.Dispose();
            }
        }

        private void UserEditorForm_FormClosing(object sender, FormClosingEventArgs e)
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
