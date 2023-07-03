using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using Tetris2.Forms.Admin.Editors.GlassEditor;
using Tetris2.Forms.HelpForms;

namespace Tetris2
{
    public partial class GlassEditorForm : Form
    {
        private uint minHeight = 8;
        private uint maxHeight = 40;
        private uint minWidth = 6;
        private uint maxWidth = 30;

        private Glass glass;
        private List<Glass> glasses;
        private EditeLevelForm elf;
        public GlassEditorForm(Glass Glass, List<Glass> Glasses, EditeLevelForm Elf)
        {
            InitializeComponent();
            glass = Glass;
            tbHeight.Text = glass.getHeight().ToString();
            tbWidth.Text = glass.getWidth().ToString();
            glasses = Glasses;
            elf = Elf;
            refreshingWeb();
        }

        private void tbWidth_TextChanged(object sender, EventArgs e)
        {
            if(isCorrect())
                refreshingWeb();
        }

        private void tbHeight_TextChanged(object sender, EventArgs e)
        {
            if (isCorrect())
                refreshingWeb();
        }

        private void refreshingWeb()
        {
            glass.setHeight(int.Parse(tbHeight.Text));
            glass.setWidth(int.Parse(tbWidth.Text));
            int qCubeWidth = Int32.Parse(tbWidth.Text);
            int qCubeHeight = Int32.Parse(tbHeight.Text);
            Bitmap bmp = new Bitmap(pbNet.Size.Width, pbNet.Size.Height);
            Graphics graphics = Graphics.FromImage(bmp);
            Pen pen = new Pen(Color.Black);

            double deltaLinesX = pbNet.Size.Width / (double)qCubeWidth;
            double deltaLinesY = pbNet.Size.Height / (double)qCubeHeight;
            double deltaLines = deltaLinesX > deltaLinesY ? deltaLinesY : deltaLinesX;

            double linePositionX = 0;
            double linePositionY = 0;
            for (int i = 0; i < qCubeWidth; ++i)
            {
                graphics.DrawLine(pen, (int)linePositionX, 0, (int)linePositionX, (int)(qCubeHeight * deltaLines));
                linePositionX += deltaLines;
            }
            for (int i = 0; i < qCubeHeight; ++i)
            {
                graphics.DrawLine(pen, 0, (int)linePositionY, (int)(qCubeWidth * deltaLines), (int)linePositionY);
                linePositionY += deltaLines;
            }

            int endPosition = deltaLinesX > deltaLinesY ? (int)(qCubeWidth * deltaLines) : bmp.Width - 1;
            graphics.DrawLine(pen, endPosition, 0, endPosition, (int)(qCubeHeight * deltaLines));

            endPosition = deltaLinesX > deltaLinesY ? bmp.Height - 1 : (int)(qCubeHeight * deltaLines);
            graphics.DrawLine(pen, 0, endPosition, (int)(qCubeWidth * deltaLines), endPosition);

            pbNet.Image = bmp;

        }

        private bool isCorrect()
        {
            try
            {
                uint.Parse(tbHeight.Text);
                if (uint.Parse(tbHeight.Text) > maxHeight || uint.Parse(tbHeight.Text) < minHeight) throw new Exception();
                uint.Parse(tbWidth.Text);
                if (uint.Parse(tbWidth.Text) > maxWidth || uint.Parse(tbWidth.Text) < minWidth) throw new Exception();
            }
            catch (Exception)
            {
                return false;
            }
            return true;
        }

        private bool isUnique()
        {
            for(int i = 0; i < glasses.Count; ++i)
            {
                if (glasses.ElementAt(i).getHeight() == glass.getHeight() && glasses.ElementAt(i).getWidth() == glass.getWidth())
                    return false;
            }
            return true;
        }

        private void btnSave_Click(object sender, EventArgs e)
        {
           if(isCorrect() && isUnique())
            {
                glasses.Add(glass);
                elf.setGlasses(glasses);
                elf.showGlasses();
                elf.Show();
                elf.Location = new Point(this.Location.X, this.Location.Y);
                this.Dispose();
            }
        }

        private void btnGoBack_Click(object sender, EventArgs e)
        {
            elf.showGlasses();
            elf.Show();
            elf.Location = new Point(this.Location.X, this.Location.Y);
            this.Dispose();
        }

        private void GlassEditorForm_FormClosing(object sender, FormClosingEventArgs e)
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
