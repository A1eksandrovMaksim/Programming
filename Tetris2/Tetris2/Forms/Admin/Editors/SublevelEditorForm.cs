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

namespace Tetris2.Forms.Admin.Editors
{
    public partial class SublevelEditorForm : Form
    {
        private Sublevel sublevel;
        private List<Sublevel> sublevels;
        private SublevelsEditorForm sef;

        public SublevelEditorForm(Sublevel sl, List<Sublevel> sls, SublevelsEditorForm _sef)
        {
            InitializeComponent();
            sublevel = sl;
            if (sl.getSublevelId() == 1)
            {
                tbPoints.Text = "0";
                tbPoints.Enabled = false;
                sublevel.setLimitPoints(0);
            }
            sublevels = sls;
            sef = _sef;
            tbPoints.Text = sublevel.getLimitPoints().ToString();
        }

        private void btnSave_Click(object sender, EventArgs e)
        {
            long limitPoints;
            try
            {
                limitPoints = long.Parse(tbPoints.Text);
                if (limitPoints < 0)
                {
                    tbPoints.Text = sublevel.getLimitPoints().ToString();
                    tbPoints.BackColor = Color.Red;
                    return;
                }
            }
            catch (Exception) { tbPoints.BackColor = Color.Red; return; }

            if (sublevel.getSublevelId() == sublevels.Count + 1)
            {
                if (sublevels.Count != 0 && sublevels.ElementAt(sublevels.Count - 1).getLimitPoints() >= limitPoints)
                {
                    tbPoints.Text = sublevel.getLimitPoints().ToString();
                    tbPoints.BackColor = Color.Red;
                    return;
                }
                sublevel.setLimitPoints(limitPoints);
                sublevels.Add(sublevel);
            }
            else
            {
                if (sublevel.getSublevelId() != sublevels.Count
                    && sublevels.ElementAt(sublevel.getSublevelId()).getLimitPoints() <= limitPoints)
                {
                    tbPoints.Text = sublevel.getLimitPoints().ToString();
                    tbPoints.BackColor = Color.Red;
                    return;
                }
                if (sublevel.getSublevelId() != 1
                    && sublevels.ElementAt(sublevel.getSublevelId() - 2).getLimitPoints() >= limitPoints)
                {
                    tbPoints.Text = sublevel.getLimitPoints().ToString();
                    tbPoints.BackColor = Color.Red;
                    return;
                }
                sublevels.ElementAt(sublevel.getSublevelId() - 1).setLimitPoints(limitPoints);
            }

            sef.setSublevels(sublevels);
            sef.showSublevels();
            sef.Show();
            sef.Location = new Point(this.Location.X, this.Location.Y);
            this.Dispose();
        }

        private void btnCancel_Click(object sender, EventArgs e)
        {
            sef.Show();
            sef.Location = new Point(this.Location.X, this.Location.Y);
            this.Dispose();
        }

        private void SublevelEditorForm_FormClosing(object sender, FormClosingEventArgs e)
        {
            Application.Exit();
        }
    }
}
