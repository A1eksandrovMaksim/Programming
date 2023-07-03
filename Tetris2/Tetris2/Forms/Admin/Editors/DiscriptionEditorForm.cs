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
    public partial class DiscriptionEditorForm : Form
    {
        private string discription;
        private EditeLevelForm elf;
        public DiscriptionEditorForm(string Discription, EditeLevelForm Elf)
        {
            InitializeComponent();
            discription = Discription;
            tbDiscription.Text = discription;
            elf = Elf;
        }

        public string getDiscription()
        {
            return discription;
        }

        private void btnSave_Click(object sender, EventArgs e)
        {
            elf.Show();
            elf.Location = new Point(this.Location.X, this.Location.Y);
            elf.setDiscription(tbDiscription.Text);
            this.Dispose();
        }

        private void btnGoBack_Click(object sender, EventArgs e)
        {
            elf.Show();
            elf.Location = new Point(this.Location.X, this.Location.Y);
            this.Dispose();
        }

        private void DiscriptionEditorForm_FormClosing(object sender, FormClosingEventArgs e)
        {
            Application.Exit();
        }

        private void btn_question_Click(object sender, EventArgs e)
        {
            new AboutDevelopersForm().ShowDialog();
        }
    }
}
