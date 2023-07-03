using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using Tetris2.Forms.Admin.Editors.BlockEditor;
using Tetris2.Forms.HelpForms;

namespace Tetris2
{
    public partial class BlockEditorForm : Form
    {
        private Block block;
        private List<Block> blocks;
        private EditeLevelForm elf;
        public BlockEditorForm(Block Block, List<Block> Blocks, EditeLevelForm Elf)
        {
            InitializeComponent();
            refreshBlock();
            block = Block;
            blocks = Blocks;
            elf = Elf;
            showBlock();
        }

        private void refreshBlock()
        {
            Bitmap bmp = new Bitmap(pbBlock.Size.Width, pbBlock.Size.Height);
            Graphics graphics = Graphics.FromImage(bmp);
            Pen pen = new Pen(Color.Black);

            double deltaLinesX = (pbBlock.Size.Width-1) / 4.0;
            double deltaLinesY = (pbBlock.Size.Height-1) / 4.0;
            double linePositionX = 0;
            double linePositionY = 0;
            for (int i = 0; i < 4; ++i)
            {
                graphics.DrawLine(pen, (int)linePositionX, 0, (int)linePositionX, pbBlock.Size.Height);
                graphics.DrawLine(pen,  0, (int)linePositionY, pbBlock.Size.Width, (int)linePositionY);
                linePositionX += deltaLinesX;
                linePositionY += deltaLinesY;
            }
            graphics.DrawLine(pen, pbBlock.Size.Width-1, 0, pbBlock.Size.Width-1, pbBlock.Size.Height);
            graphics.DrawLine(pen, 0, pbBlock.Size.Height-1, pbBlock.Size.Width, pbBlock.Size.Height-1);

            pbBlock.Image = bmp;
        }

        private void showBlock()
        {
            refreshBlock();
            Bitmap bmp = new Bitmap(pbBlock.Image);
            Graphics graphics = Graphics.FromImage(bmp);
            Brush brush = new SolidBrush(Color.Black);

            double deltaLinesX = (pbBlock.Size.Width - 1) / 4.0;
            double deltaLinesY = (pbBlock.Size.Height - 1) / 4.0;
            double linePositionY = 0;
            for (int y = 0; y < 4; ++y)
            {
                double linePositionX = 0;
                for (int x = 0; x < 4; ++x)
                {
                    if (block.checkState(x+1, y+1))
                    {
                        
                        graphics.FillRectangle(brush,
                            new Rectangle((int)linePositionX + 1, (int)linePositionY + 1,
                                          (int)deltaLinesX, (int)deltaLinesY));
                    }
                    linePositionX += deltaLinesX;
                }
                linePositionY += deltaLinesY;
            }
            pbBlock.Image = bmp;
        }

        private void pbBlock_MouseClick(object sender, MouseEventArgs e)
        {
            double deltaLinesX = (pbBlock.Size.Width - 1) / 4.0;
            double deltaLinesY = (pbBlock.Size.Height - 1) / 4.0;
            double linePositionX = deltaLinesX;
            double linePositionY = deltaLinesY;
            bool done = false;
            for (int y = 0; y < 4; ++y) {
                linePositionX = deltaLinesX;
                for (int x = 0; x < 4; ++x)
                {
                    if (linePositionX > e.X && linePositionY > e.Y)
                    {
                        done = true;
                        block.changeState(x+1, y+1);
                        break;
                    }
                    linePositionX += deltaLinesX;
                }
                if (done) break;
                linePositionY += deltaLinesY;
            }
            showBlock();
        }

        private void btnSave_Click(object sender, EventArgs e)
        {
            if(block.isCorrect() && isUnique())
            {
                
                blocks.Add(block);
                elf.setBlocks(blocks);
                elf.Show();
                elf.Location = new Point(this.Location.X, this.Location.Y);
                elf.showBlocks();
                this.Dispose();
            }
            showBlock();
        }

        private bool isUnique()
        {
            bool isUnique = true;
            for(int i = 0; i < 4; ++i)
            {
                block.shiftLeft();
                block.shiftUp();
                for(int j = 0; j < blocks.Count; ++j)
                {
                    if(blocks.ElementAt(j).getState() == block.getState())
                    {
                        isUnique = false;
                    }
                }
                block.turnRight();
            }
            block.shiftLeft();
            block.shiftUp();
            return isUnique;
        }

        private void btnTurnRight_Click(object sender, EventArgs e)
        {
            block.turnRight();
            showBlock();
        }

        private void btnTurnLeft_Click(object sender, EventArgs e)
        {
            block.turnLeft();
            showBlock();
        }

        private void btnGoBack_Click(object sender, EventArgs e)
        {
            elf.Show();
            elf.Location = new Point(this.Location.X, this.Location.Y);
            elf.showBlocks();
            this.Dispose();
        }

        private void BlockEditorForm_FormClosing(object sender, FormClosingEventArgs e)
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
