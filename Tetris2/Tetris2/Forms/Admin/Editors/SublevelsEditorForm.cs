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
    public partial class SublevelsEditorForm : Form
    {
        private List<Sublevel> sublevels;
        private EditeLevelForm elf;
        private int maxQuantitySublevels;
        public SublevelsEditorForm(List<Sublevel> _sublevels, int maxQSubs, EditeLevelForm _elf)
        {
            sublevels = _sublevels;
            maxQuantitySublevels = maxQSubs;
            elf = _elf;
            InitializeComponent();
            showSublevels();
        }

        public void showSublevels()
        {
            dgvLevels.Rows.Clear();
            lbSublevels.Text = sublevels.Count.ToString();
            for(int i = 0; i < sublevels.Count; ++i)
            {
                string[] args = new string[2];
                args[0] = "Ур. " + sublevels.ElementAt(i).getSublevelId().ToString();
                args[1] = sublevels.ElementAt(i).getLimitPoints().ToString();
                dgvLevels.Rows.Add(args);
            }
            if (sublevels.Count == maxQuantitySublevels)
                btnCreateLevel.Enabled = false;
            else
                btnCreateLevel.Enabled = true;
        }

        private void btnDelete_Click(object sender, EventArgs e)
        {
            try
            {
                int numOfSelectSublevel = int.Parse(dgvLevels.SelectedRows[0].Cells[0].Value.ToString().Substring(4));
                if (numOfSelectSublevel == 1) return;
                bool isSearchedItem = false;
                for (int i = 0; i < sublevels.Count; ++i)
                {
                    if (!isSearchedItem)
                    {
                        if (sublevels.ElementAt(i).getSublevelId() == numOfSelectSublevel)
                        {
                            sublevels.RemoveAt(i);
                            i--;
                            isSearchedItem = true;
                        }
                    }
                    else
                    {
                            sublevels.ElementAt(i).setSublevelId(sublevels.ElementAt(i).getSublevelId()-1);
                    }
                }
                showSublevels();
             }
            catch (Exception) { return; }
        }
        public void setSublevels(List<Sublevel> sls)
        {
            sublevels = sls;
        }

        private void btnCreateLevel_Click(object sender, EventArgs e)
        {
            this.Hide();
            SublevelEditorForm sef = new SublevelEditorForm(
                new Sublevel(sublevels.Count == 0 ? 0 : sublevels.ElementAt(sublevels.Count - 1).getLimitPoints() + 1,
                sublevels.Count + 1), sublevels, this);
            sef.Show();
            sef.Location = new Point(this.Location.X, this.Location.Y);
        }

        private void btnEditeLavel_Click(object sender, EventArgs e)
        {
            try
            {
                int numOfSelectSublevel = int.Parse(dgvLevels.SelectedRows[0].Cells[0].Value.ToString().Substring(4));
                this.Hide();
                SublevelEditorForm sef = new SublevelEditorForm(
                    sublevels.ElementAt(numOfSelectSublevel - 1), sublevels, this);
                sef.Show();
                sef.Location = new Point(this.Location.X, this.Location.Y);
            } catch (Exception) { return; }
        }

        private void btnGoBack_Click(object sender, EventArgs e)
        {
            elf.setSublevels(sublevels);
            elf.showSublevels();
            elf.Show();
            elf.Location = new Point(this.Location.X, this.Location.Y);
            this.Dispose();
        }

        private void SublevelsEditorForm_FormClosing(object sender, FormClosingEventArgs e)
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
