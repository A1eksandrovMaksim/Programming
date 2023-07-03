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
using Tetris2.Forms.Admin.Editors;
using Tetris2.Forms.Admin.Editors.BlockEditor;
using Tetris2.Forms.Admin.Editors.GlassEditor;
using Tetris2.Forms.HelpForms;

namespace Tetris2
{
    public partial class AdminMainForm : Form
    {
        private List<Level> levels = new List<Level>();
        HelloForm hf;
        public AdminMainForm(HelloForm Hf)
        {
            InitializeComponent();
            loadLevels();
            showLevels();
            hf = Hf;
        }

        public void loadLevels()
        {
            levels = new List<Level>();
            SQLConnect sql = new SQLConnect();
            DataTable dt = sql.getData("select * from level_tb");
            foreach (DataRow r in dt.Rows)
            {
                List<Block> blocks = new List<Block>();
                DataTable dtBlocks = sql.getData("select state_map, in_game " +
                    "from block where level_id=" + r.ItemArray[0].ToString());
                foreach (DataRow block in dtBlocks.Rows)
                {
                    blocks.Add(new Block(uint.Parse(block.ItemArray[0].ToString()),
                        bool.Parse(block.ItemArray[1].ToString())));
                }

                List<Sublevel> sublevels = new List<Sublevel>();
                DataTable dtSublevels = sql.getData("select sublevel_id_in_level, " +
                    "limit_points from sublevel where level_id=" + r.ItemArray[0].ToString() +
                    " order by sublevel_id_in_level asc");
                foreach (DataRow sublevel in dtSublevels.Rows)
                {
                    sublevels.Add(new Sublevel(long.Parse(sublevel.ItemArray[1].ToString()),
                        int.Parse(sublevel.ItemArray[0].ToString())));
                }

                List<Glass> glasses = new List<Glass>();
                DataTable dtGlasses = sql.getData("select width, height, in_game " +
                    "from glass where level_id = " + r.ItemArray[0].ToString());
                foreach (DataRow glass in dtGlasses.Rows)
                {
                    glasses.Add(new Glass(int.Parse(glass.ItemArray[0].ToString()),
                        int.Parse(glass.ItemArray[1].ToString()),
                        bool.Parse(glass.ItemArray[2].ToString())));
                }


                Level level = new Level(
                    r.ItemArray[2].ToString(),
                    Int32.Parse(r.ItemArray[1].ToString()),
                    Double.Parse(r.ItemArray[3].ToString()),
                    bool.Parse(r.ItemArray[4].ToString()),
                    int.Parse(r.ItemArray[5].ToString()),
                    blocks,
                    glasses,
                    sublevels
                    );
                levels.Add(level);
            }
        }

        public void showLevels()
        {
            dgvLevels.Rows.Clear();
            int i = 0;
            foreach(Level lv in levels)
            {
                string[] args = new string[2];
                args[0] = "No. " + lv.getNumberOfLevel().ToString();
                args[1] = lv.getDiscription();
                dgvLevels.Rows.Add(args);
                dgvLevels.Rows[i].Cells[1].ToolTipText = lv.getDiscription();
                ++i;
            }
        }

        private void btnDelete_Click(object sender, EventArgs e)
        {
            try
            {
                int numOfSelectLevel = int.Parse(dgvLevels.SelectedRows[0].Cells[0].Value.ToString().Substring(4));
                SQLConnect sql = new SQLConnect();
                sql.setData("delete from glass where level_id = " + numOfSelectLevel.ToString());
                sql.setData("delete from block where level_id = " + numOfSelectLevel.ToString());
                sql.setData("delete from sublevel where level_id = " + numOfSelectLevel.ToString());
                sql.setData("delete from statistic where level_id = " + numOfSelectLevel.ToString());
                sql.setData("delete from level_tb where level_id = " + numOfSelectLevel.ToString());
            }
            catch (Exception ex) { return; }
            loadLevels();
            showLevels();
        }

        private void btnCreateLevel_Click(object sender, EventArgs e)
        {
            this.Hide();
            EditeLevelForm elf = new EditeLevelForm(this);
            elf.Show();
            elf.Location = new Point(this.Location.X, this.Location.Y);
        }

        private void btnEditeLavel_Click(object sender, EventArgs e)
        {
            try
            {
                int numOfSelectLevel = int.Parse(dgvLevels.SelectedRows[0].Cells[0].Value.ToString().Substring(4));
                int i = 0;
                for(; i < levels.Count; ++i)
                {
                    if (levels[i].getNumberOfLevel() == numOfSelectLevel)
                        break;
                }
                this.Hide();
                EditeLevelForm elf = new EditeLevelForm(this, levels[i]);
                elf.Show();
                elf.Location = new Point(this.Location.X, this.Location.Y);
            }
            catch (Exception) { return; }
        }

        private void btnGoHome_Click(object sender, EventArgs e)
        {
            hf.Show();
            hf.Location = new Point(this.Location.X, this.Location.Y);
            this.Dispose();
        }

        private void btnEditUsers_Click(object sender, EventArgs e)
        {
            this.Hide();
            UsersEditorForm uef = new UsersEditorForm(this);
            uef.Show();
            uef.Location = new Point(this.Location.X, this.Location.Y);
        }

        private void AdminMainForm_FormClosing(object sender, FormClosingEventArgs e)
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
