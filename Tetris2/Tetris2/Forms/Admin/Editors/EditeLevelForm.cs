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
    public partial class EditeLevelForm : Form
    {
        private AdminMainForm amf;
        private string discription = "";
        private List<Block> blocks = new List<Block>();
        private int pictureBoxWithBlockSize = 70;
        private int paddingOfPictureBoxWithBlock = 15;
        private Color inGameColor = Color.Yellow;
        private Color noInGameColor = Color.White;

        private List<Glass> glasses = new List<Glass>();
        private List<Sublevel> sublevels = new List<Sublevel>();
        private int textBoxWidthGlassWidth = 73;
        private int textBoxWidthGlassHeight = 32;
        private int glassNameTextSize = 11;
        private string glassNameTextFontFamily = "PMingLiU-ExtB";

        private double minFallingSpeed = 0.25;
        private double maxFallingSpeed = 60;
        private int minPointsForLine = 0;
        private int maxPointsForLine = 100000;
        private int minQuantityFigures = 1;
        private int maxQuantitySublevels = 15;
        private int minQuantitySublevels = 3;

        private int numOfSelectedBlock = -1;
        private int numOfSelectedGlass = -1;




        public EditeLevelForm(AdminMainForm Amf)
        {
            InitializeComponent();
            amf = Amf;
            showBlocks();
            showGlasses();
            showSublevels();
        }
        public EditeLevelForm(AdminMainForm Amf, Level level)
        {
            InitializeComponent();
            tbNumberOfLevel.Text = level.getNumberOfLevel().ToString();
            blocks = level.getBlocks();
            glasses = level.getGlasses();
            sublevels = level.getSublevels();
            tbFallingSpeed.Text = level.getFallingSpeed().ToString();
            cbEnableNetMode.Checked = level.getEnableNetMode();
            tbPointsForLine.Text = level.getpointsForLine().ToString();
            discription = level.getDiscription();
            amf = Amf;
            tbNumberOfLevel.Enabled = false;
            showBlocks();
            showGlasses();
            showSublevels();
        }

        public void showBlocks()
        {
            flpBlocks.Controls.Clear();
            for(int i = 0; i < blocks.Count; ++i)
            {
                PictureBox pb = new PictureBox();
                pb.Size = new Size(pictureBoxWithBlockSize, pictureBoxWithBlockSize);
                pb.Name = "pbBlock_" + i.ToString();
                pb.Image = putBlockInImage(blocks.ElementAt(i), pictureBoxWithBlockSize, 
                                            paddingOfPictureBoxWithBlock, 
                                            blocks.ElementAt(i).checkInGame() ? inGameColor : noInGameColor, Color.Black);
                pb.MouseClick += selectBlock;
                pb.MouseClick += changeInGameOfBlock;
                flpBlocks.Controls.Add(pb);
            }
        }

        public void showGlasses()
        {
            flpGlasses.Controls.Clear();
            for (int i = 0; i < glasses.Count; ++i)
            {
                TextBox tb = new TextBox();
                tb.Size = new Size(textBoxWidthGlassWidth, textBoxWidthGlassHeight);
                tb.Name = "tbGlass_" + i.ToString();
                tb.Text = glasses.ElementAt(i).getWidth().ToString() + " X " + glasses.ElementAt(i).getHeight().ToString();
                tb.Font = new Font(glassNameTextFontFamily, glassNameTextSize);
                tb.TextAlign = HorizontalAlignment.Center;
                tb.ReadOnly = true;
                tb.Cursor = Cursors.Default;
                tb.BackColor = glasses.ElementAt(i).checkInGame()?inGameColor:noInGameColor;
                tb.MouseClick += changeInGameOfGlass;
                flpGlasses.Controls.Add(tb);
            }
        }

        public void showSublevels()
        {
            lbSublevels.Text = sublevels.Count.ToString();
        }

        private Bitmap putBlockInImage(Block block, int imgSize, int paddingOfBlock, Color bgColor, Color borderColor)
        {
            Bitmap bmp = new Bitmap(imgSize, imgSize);
            Graphics graphics = Graphics.FromImage(bmp);
            Brush brush = new SolidBrush(Color.Black);
            Pen pen = new Pen(brush);

            graphics.FillRectangle(new SolidBrush(borderColor), 0, 0, imgSize, imgSize); // make border
            graphics.FillRectangle(new SolidBrush(bgColor), 1, 1, imgSize-2, imgSize-2);

            int xy_0 = paddingOfBlock;
            int xy_end = imgSize - paddingOfBlock;
            double delta = (xy_end - xy_0) / 4.0;

            graphics.FillRectangle(new SolidBrush(Color.White), xy_0, xy_0, xy_end-xy_0, xy_end-xy_0); // clear space for block

            double linePosition = xy_0;

            for(int i = 0; i < 4; ++i)
            {
                graphics.DrawLine(pen, xy_0, (int)linePosition, xy_end, (int)linePosition);
                graphics.DrawLine(pen, (int)linePosition, xy_0, (int)linePosition, xy_end);
                linePosition += delta;
            }
            graphics.DrawLine(pen, xy_0, xy_end, xy_end, xy_end);
            graphics.DrawLine(pen, xy_end, xy_0, xy_end, xy_end);

            double blockY0 = xy_0;
            for(int blockCoordY = 1; blockCoordY < 5; ++blockCoordY)
            {
                double blockX0 = xy_0;
                for (int blockCoordX = 1; blockCoordX < 5; ++blockCoordX)
                {
                    if(block.checkState(blockCoordX, blockCoordY))
                    {
                        graphics.FillRectangle(brush, (int)blockX0, (int)blockY0, (int)delta, (int)delta);
                    }
                    blockX0 += delta;
                }
                blockY0 += delta;
            }
            return bmp;
        }

        private void changeInGameOfBlock(object sender, MouseEventArgs e)
        {
            if (e.Button != MouseButtons.Middle) return;
            PictureBox pb = (PictureBox)sender;
            int numOfBlock = int.Parse(pb.Name.ElementAt(pb.Name.Length - 1).ToString());
            if (blocks.ElementAt(numOfBlock).checkInGame())
            {
                blocks.ElementAt(numOfBlock).setInGame(false);
                pb.Image = putBlockInImage(blocks.ElementAt(numOfBlock), pictureBoxWithBlockSize, paddingOfPictureBoxWithBlock, noInGameColor, Color.Black);
            }
            else
            {
                blocks.ElementAt(numOfBlock).setInGame(true);
                pb.Image = putBlockInImage(blocks.ElementAt(numOfBlock), pictureBoxWithBlockSize, paddingOfPictureBoxWithBlock, inGameColor, Color.Black);
            }
           
        }

        private void selectBlock(object sender, MouseEventArgs e)
        {
            if (e.Button != MouseButtons.Left) return;
            PictureBox pb = (PictureBox)sender;
            int numOfBlock = int.Parse(pb.Name.ElementAt(pb.Name.Length - 1).ToString());
            numOfSelectedBlock = numOfBlock;

            for (int i = 0; i < flpBlocks.Controls.Count; ++i)
            {
                PictureBox pbt = (PictureBox)(flpBlocks.Controls[i]);
                pbt.BorderStyle = BorderStyle.None;  
            }
            pb.BorderStyle = BorderStyle.Fixed3D;
        }

        private void changeInGameOfGlass(object sender, MouseEventArgs e)
        {
            if (e.Button != MouseButtons.Left) return;
            TextBox tb = (TextBox)sender;
            int numOfGlass = int.Parse(tb.Name.ElementAt(tb.Name.Length - 1).ToString());
            numOfSelectedGlass = numOfGlass;
            foreach (Glass gl in glasses){
                if (gl.checkInGame())
                    gl.setInGame(false);
            }
            glasses.ElementAt(numOfGlass).setInGame(true);

            for(int i = 0; i < flpGlasses.Controls.Count; ++i)
            {
                if (i == numOfGlass)
                    flpGlasses.Controls.Find(("tbGlass_" + i.ToString()), false).ElementAt(0).BackColor = inGameColor;
                else
                    flpGlasses.Controls.Find(("tbGlass_" + i.ToString()), false).ElementAt(0).BackColor = noInGameColor;
            }
        }

        private bool isUniqueId(int id, DataTable ids)
        {
            for(int i = 0; i < ids.Rows.Count; ++i)
            {
                if (id == int.Parse(ids.Rows[i].ItemArray[0].ToString()))
                    return false;
            }
            return true;
        }

        private void saveBlocks(SQLConnect sql)
        {
            DataTable dt = sql.getData("select block_id from block");
            int block_id = 0;
            for (int i = 0; i < blocks.Count; ++i)
            {
                while (true)
                {
                    ++block_id;
                    if (isUniqueId(block_id, dt))
                        break;
                }
                sql.setData("insert into block values (" +
                    block_id.ToString() + ", " 
                    + blocks.ElementAt(i).getState().ToString() 
                    + ", " + blocks.ElementAt(i).checkInGame().ToString() 
                    + ", " + tbNumberOfLevel.Text + ")");
            }
        }

        private void saveGlasses(SQLConnect sql)
        {
            DataTable dt = sql.getData("select glass_id from glass");
            int glass_id = 0;
            for (int i = 0; i < glasses.Count; ++i)
            {
                while (true)
                {
                    ++glass_id;
                    if (isUniqueId(glass_id, dt))
                        break;
                }
                sql.setData("insert into glass values (" +
                    glass_id.ToString() 
                    + ", " + glasses.ElementAt(i).getHeight().ToString() 
                    + ", " + glasses.ElementAt(i).getWidth().ToString() 
                    + ", " + glasses.ElementAt(i).checkInGame().ToString() 
                    + ", " + tbNumberOfLevel.Text + ")");
            }
        }

        private void saveSublevels(SQLConnect sql)
        {
            DataTable dt = sql.getData("select sublevel_id from sublevel");
            int sublevel_id = 0;
            for (int i = 0; i < sublevels.Count; ++i)
            {
                while (true)
                {
                    ++sublevel_id;
                    if (isUniqueId(sublevel_id, dt))
                        break;
                }
                sql.setData("insert into sublevel values (" +
                    sublevel_id.ToString()
                    + ", " + sublevels.ElementAt(i).getSublevelId().ToString()
                    + ", " + sublevels.ElementAt(i).getLimitPoints().ToString()
                    + ", " + tbNumberOfLevel.Text + ")");
            }
        }

        private void btnSaveLevel_Click(object sender, EventArgs e)
        {
            if(!checkCorrectLevel())return;
            SQLConnect sql = new SQLConnect();
            if(tbNumberOfLevel.Enabled)
            {
                if(sql.getData("select * from level_tb where level_id=" + tbNumberOfLevel.Text).Rows.Count != 0)
                {
                    tbNumberOfLevel.BackColor = Color.Red;
                    return;
                }

                sql.setData("insert into level_tb values (" + tbNumberOfLevel.Text + ", " + tbNumberOfLevel.Text
                    + ", '" + discription + "', " + parseCorrectDoubleFormat(tbFallingSpeed.Text)
                    + ", " + cbEnableNetMode.Checked.ToString()
                    + ", " + tbPointsForLine.Text + ")");

                saveSublevels(sql);
                saveBlocks(sql);
                saveGlasses(sql);
            }
            else
            {
                sql.setData("update level_tb set discription='" + discription + "', " +
                " falling_speed=" + parseCorrectDoubleFormat(tbFallingSpeed.Text)
                + ", enable_net_mode=" + cbEnableNetMode.Checked.ToString()
                + ", points_for_line=" + tbPointsForLine.Text
                + " where level_id=" + tbNumberOfLevel.Text);

                sql.setData("delete from block where level_id=" + tbNumberOfLevel.Text);
                sql.setData("delete from glass where level_id=" + tbNumberOfLevel.Text);
                sql.setData("delete from sublevel where level_id=" + tbNumberOfLevel.Text);
                saveBlocks(sql);
                saveGlasses(sql);
                saveSublevels(sql);
            }
            amf.Location = new Point(this.Location.X, this.Location.Y);
            amf.Show();
            amf.loadLevels();
            amf.showLevels();
            this.Dispose();
        }

        private string parseCorrectDoubleFormat(String str)
        {
            string newStr = "";
            for(int i = 0; i < str.Length; ++i)
            {
                if (str.ElementAt(i) == ',')
                    newStr += '.';
                else
                    newStr += str.ElementAt(i);
            }
            return newStr;
        }

        private bool checkCorrectLevel()
        {
            bool isCorrect = true;
            try
            {
                double a = double.Parse(tbFallingSpeed.Text);
                if (a < minFallingSpeed || a > maxFallingSpeed)
                {
                    tbFallingSpeed.BackColor = Color.Red; isCorrect = false;
                }
                else
                    tbFallingSpeed.BackColor = Color.LimeGreen;
            }
            catch (Exception ex) { tbFallingSpeed.BackColor = Color.Red; isCorrect = false; }

            try
            {
                int a = int.Parse(tbPointsForLine.Text);
                if (a < minPointsForLine || a > maxPointsForLine)
                {
                    tbPointsForLine.BackColor = Color.Red; isCorrect = false;
                }
                else
                    tbPointsForLine.BackColor = Color.LimeGreen;
            }
            catch (Exception) { tbPointsForLine.BackColor = Color.Red; isCorrect = false; }

            try
            {
                int.Parse(tbNumberOfLevel.Text);
                tbNumberOfLevel.BackColor = Color.LimeGreen;
            }
            catch (Exception) { tbNumberOfLevel.BackColor = Color.Red; isCorrect = false; }

            int quantityFigures = 0;
            foreach(Block block in blocks)
            {
                if (block.checkInGame())
                    ++quantityFigures;
            }
            if(quantityFigures < minQuantityFigures)
            {
                flpBlocks.BackColor = Color.Red;
                isCorrect = false;
            }
            else
                flpBlocks.BackColor = Color.LimeGreen;

            bool isGlassInGame = false;
            foreach (Glass glass in glasses)
            {
                if (glass.checkInGame())
                {
                    isGlassInGame = true;
                    break;
                }
            }
            if (!isGlassInGame)
            {
                flpGlasses.BackColor = Color.Red;
                isCorrect = false;
            }
            else
            flpGlasses.BackColor = Color.LimeGreen;

            if (int.Parse(lbSublevels.Text) > maxQuantitySublevels || int.Parse(lbSublevels.Text) < minQuantitySublevels)
            {
                lbSublevels.BackColor = Color.Red;
                isCorrect = false;
            }
            else
                lbSublevels.BackColor = Color.LimeGreen;


            return isCorrect;
        }

        private void btnAddDiscription_Click(object sender, EventArgs e)
        {
            this.Hide();
            DiscriptionEditorForm def = new DiscriptionEditorForm(discription, this);
            def.Show();
            def.Location = new Point(this.Location.X, this.Location.Y);
        }
        public void setDiscription(string Discription)
        {
            discription = Discription;
        }

        private void btnAddBlock_Click(object sender, EventArgs e)
        {
            this.Hide();
            BlockEditorForm bef = new BlockEditorForm(new Block(0), blocks, this);
            bef.Show();
            bef.Location = new Point(this.Location.X, this.Location.Y);
        }
        public void setBlocks(List<Block> Blocks)
        {
            blocks = Blocks;
        }

        private void btnEditBlock_Click(object sender, EventArgs e)
        {
            if (numOfSelectedBlock == -1) return;
            this.Hide();
            Block block = blocks.ElementAt(numOfSelectedBlock);
            blocks.RemoveAt(numOfSelectedBlock);
            BlockEditorForm bef = new BlockEditorForm(new Block(block.getState()), blocks, this);
            bef.Show();
            bef.Location = new Point(this.Location.X, this.Location.Y);

        }

        private void btnDeleteBlock_Click(object sender, EventArgs e)
        {
            if (numOfSelectedBlock == -1) return;
            blocks.RemoveAt(numOfSelectedBlock);
            numOfSelectedBlock = -1;
            showBlocks();
        }

        private void btnAddGlass_Click(object sender, EventArgs e)
        {
            this.Hide();
            GlassEditorForm gef = new GlassEditorForm(new Glass(10, 10), glasses, this);
            gef.Show();
            gef.Location = new Point(this.Location.X, this.Location.Y);
        }

        public void setGlasses(List<Glass> Glasses)
        {
            glasses = Glasses;
        }

        private void btnEditGlass_Click(object sender, EventArgs e)
        {
            if (numOfSelectedGlass == -1) return;
            this.Hide();
            Glass glass = glasses.ElementAt(numOfSelectedGlass);
            glasses.RemoveAt(numOfSelectedGlass);
            GlassEditorForm gef = new GlassEditorForm(new Glass(glass.getWidth(), glass.getHeight()), glasses, this);
            gef.Show();
            gef.Location = new Point(this.Location.X, this.Location.Y);

        }

        private void btnDeleteGlass_Click(object sender, EventArgs e)
        {
            if (numOfSelectedGlass == -1) return;
            glasses.RemoveAt(numOfSelectedGlass);
            numOfSelectedGlass = -1;
            showGlasses();
        }

        public void setSublevels(List<Sublevel> sls)
        {
            sublevels = sls;
        }

        private void btnGoBack_Click(object sender, EventArgs e)
        {
            amf.Location = new Point(this.Location.X, this.Location.Y);
            amf.Show();
            amf.Location = new Point(this.Location.X, this.Location.Y);
            amf.loadLevels();
            amf.showLevels();
            this.Dispose();
        }

        private void btnEditSublevels_Click(object sender, EventArgs e)
        {
            this.Hide();
            SublevelsEditorForm sef = new SublevelsEditorForm(sublevels, maxQuantitySublevels, this);
            sef.Show();
            sef.Location = new Point(this.Location.X, this.Location.Y);
        }

        private void EditeLevelForm_FormClosing(object sender, FormClosingEventArgs e)
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
