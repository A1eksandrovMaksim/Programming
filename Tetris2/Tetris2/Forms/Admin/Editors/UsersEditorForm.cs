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
    public partial class UsersEditorForm : Form
    {
        private AdminMainForm amf;
        public UsersEditorForm(AdminMainForm _amf)
        {
            InitializeComponent();
            amf = _amf;
            showUsers();
        }

        public void showUsers()
        {
            SQLConnect sql = new SQLConnect();
            DataTable dt = sql.getData("select login, users_password from user_tb");
            dgvUsers.Rows.Clear();
            int i = 0;
            foreach (DataRow r in dt.Rows)
            {
                string[] args = new string[1];
                args[0] = r.ItemArray[0].ToString();
                dgvUsers.Rows.Add(args);
                dgvUsers.Rows[i].Cells[0].ToolTipText = r.ItemArray[1].ToString();
                ++i;
            }
        }
        private void btnGoHome_Click(object sender, EventArgs e)
        {
            amf.Show();
            amf.Location = new Point(this.Location.X, this.Location.Y);
            this.Dispose();
        }

        private void btnDelete_Click(object sender, EventArgs e)
        {
            try
            {
                SQLConnect sql = new SQLConnect();
                sql.setData("delete from statistic where user_id " +
                    "= (select user_id from user_tb where login='"
                    + dgvUsers.SelectedRows[0].Cells[0].Value.ToString() +"')");
                sql.setData("delete from user_tb where login='"
                    + dgvUsers.SelectedRows[0].Cells[0].Value.ToString() + "'");
                showUsers();
            }
            catch (Exception ex) { return; }
        }

        private void btnAdd_Click(object sender, EventArgs e)
        {
            int user_id = 0;
            while (true)
            {
                ++user_id;
                if (isUniqueId(user_id))
                    break;
            }
            this.Hide();
            UserEditorForm uef = new UserEditorForm(new UserClass(user_id, "", ""), this);
            uef.Show();

        }

        private bool isUniqueId(int id)
        {
            SQLConnect sql = new SQLConnect();
            if(sql.getData("select * from user_tb where user_id=" + id).Rows.Count==0)
                return true;
            else
                return false;
        }

        private void btnEdit_Click(object sender, EventArgs e)
        {
            try
            {
                SQLConnect sql = new SQLConnect();
                DataTable dt = sql.getData("select * from user_tb where login='"
                    + dgvUsers.SelectedRows[0].Cells[0].Value.ToString() + "'");

                this.Hide();
                UserEditorForm uef = new UserEditorForm(new UserClass(
                    int.Parse(dt.Rows[0].ItemArray[0].ToString()),
                    dt.Rows[0].ItemArray[1].ToString(),
                    dt.Rows[0].ItemArray[2].ToString()), this);
                uef.Show();
                uef.Location = new Point(this.Location.X, this.Location.Y);
            }
            catch (Exception) { return; }
        }

        private void UsersEditorForm_FormClosing(object sender, FormClosingEventArgs e)
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
