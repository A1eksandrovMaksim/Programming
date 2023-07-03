
namespace Tetris2
{
    partial class MainGameForm
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.pbScene = new System.Windows.Forms.PictureBox();
            this.btn_question = new System.Windows.Forms.Button();
            this.btn_inquiry = new System.Windows.Forms.Button();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.lbScore = new System.Windows.Forms.Label();
            this.pbNextShape = new System.Windows.Forms.PictureBox();
            this.label5 = new System.Windows.Forms.Label();
            this.lbTime = new System.Windows.Forms.Label();
            this.label7 = new System.Windows.Forms.Label();
            this.lbQuantityLinesRemoved = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.lbQuantityBlocksRemoved = new System.Windows.Forms.Label();
            this.label6 = new System.Windows.Forms.Label();
            this.lbLevel = new System.Windows.Forms.Label();
            this.btnEndGame = new System.Windows.Forms.Button();
            this.panelWithScene = new System.Windows.Forms.Panel();
            this.label4 = new System.Windows.Forms.Label();
            this.lbTopScore = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.pbScene)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pbNextShape)).BeginInit();
            this.panelWithScene.SuspendLayout();
            this.SuspendLayout();
            // 
            // pbScene
            // 
            this.pbScene.BackColor = System.Drawing.SystemColors.Control;
            this.pbScene.Location = new System.Drawing.Point(3, 3);
            this.pbScene.Name = "pbScene";
            this.pbScene.Size = new System.Drawing.Size(218, 304);
            this.pbScene.TabIndex = 0;
            this.pbScene.TabStop = false;
            this.pbScene.Paint += new System.Windows.Forms.PaintEventHandler(this.OnPaintMap);
            // 
            // btn_question
            // 
            this.btn_question.Font = new System.Drawing.Font("High Tower Text", 18F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btn_question.Location = new System.Drawing.Point(12, 12);
            this.btn_question.Name = "btn_question";
            this.btn_question.Size = new System.Drawing.Size(33, 36);
            this.btn_question.TabIndex = 23;
            this.btn_question.Text = "?";
            this.btn_question.UseVisualStyleBackColor = true;
            this.btn_question.Click += new System.EventHandler(this.btn_question_Click);
            // 
            // btn_inquiry
            // 
            this.btn_inquiry.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.btn_inquiry.Font = new System.Drawing.Font("High Tower Text", 18F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btn_inquiry.Location = new System.Drawing.Point(316, 12);
            this.btn_inquiry.Name = "btn_inquiry";
            this.btn_inquiry.Size = new System.Drawing.Size(33, 36);
            this.btn_inquiry.TabIndex = 24;
            this.btn_inquiry.Text = "i";
            this.btn_inquiry.UseVisualStyleBackColor = true;
            this.btn_inquiry.Click += new System.EventHandler(this.btn_inquiry_Click);
            // 
            // label1
            // 
            this.label1.Anchor = System.Windows.Forms.AnchorStyles.Top;
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Goudy Stout", 18F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(90, 12);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(193, 32);
            this.label1.TabIndex = 25;
            this.label1.Text = "Tetris";
            // 
            // label2
            // 
            this.label2.Anchor = System.Windows.Forms.AnchorStyles.Right;
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Mongolian Baiti", 12F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label2.Location = new System.Drawing.Point(252, 86);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(36, 16);
            this.label2.TabIndex = 32;
            this.label2.Text = "Счёт";
            // 
            // lbScore
            // 
            this.lbScore.Anchor = System.Windows.Forms.AnchorStyles.Right;
            this.lbScore.AutoSize = true;
            this.lbScore.Font = new System.Drawing.Font("Mongolian Baiti", 12F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lbScore.Location = new System.Drawing.Point(252, 99);
            this.lbScore.Name = "lbScore";
            this.lbScore.Size = new System.Drawing.Size(16, 16);
            this.lbScore.TabIndex = 33;
            this.lbScore.Text = "0";
            // 
            // pbNextShape
            // 
            this.pbNextShape.Anchor = System.Windows.Forms.AnchorStyles.Right;
            this.pbNextShape.BackColor = System.Drawing.SystemColors.Control;
            this.pbNextShape.Location = new System.Drawing.Point(264, 150);
            this.pbNextShape.Name = "pbNextShape";
            this.pbNextShape.Size = new System.Drawing.Size(85, 85);
            this.pbNextShape.TabIndex = 35;
            this.pbNextShape.TabStop = false;
            // 
            // label5
            // 
            this.label5.Anchor = System.Windows.Forms.AnchorStyles.Right;
            this.label5.AutoSize = true;
            this.label5.Font = new System.Drawing.Font("Mongolian Baiti", 12F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label5.Location = new System.Drawing.Point(265, 115);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(46, 16);
            this.label5.TabIndex = 36;
            this.label5.Text = "Время";
            // 
            // lbTime
            // 
            this.lbTime.Anchor = System.Windows.Forms.AnchorStyles.Right;
            this.lbTime.AutoSize = true;
            this.lbTime.Font = new System.Drawing.Font("Mongolian Baiti", 12F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lbTime.Location = new System.Drawing.Point(265, 131);
            this.lbTime.Name = "lbTime";
            this.lbTime.Size = new System.Drawing.Size(84, 16);
            this.lbTime.TabIndex = 37;
            this.lbTime.Text = "00:00:00:00";
            // 
            // label7
            // 
            this.label7.Anchor = System.Windows.Forms.AnchorStyles.Right;
            this.label7.AutoSize = true;
            this.label7.Font = new System.Drawing.Font("Mongolian Baiti", 12F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label7.Location = new System.Drawing.Point(251, 238);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(44, 16);
            this.label7.TabIndex = 38;
            this.label7.Text = "Линии";
            // 
            // lbQuantityLinesRemoved
            // 
            this.lbQuantityLinesRemoved.Anchor = System.Windows.Forms.AnchorStyles.Right;
            this.lbQuantityLinesRemoved.AutoSize = true;
            this.lbQuantityLinesRemoved.Font = new System.Drawing.Font("Mongolian Baiti", 12F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lbQuantityLinesRemoved.Location = new System.Drawing.Point(252, 254);
            this.lbQuantityLinesRemoved.Name = "lbQuantityLinesRemoved";
            this.lbQuantityLinesRemoved.Size = new System.Drawing.Size(16, 16);
            this.lbQuantityLinesRemoved.TabIndex = 39;
            this.lbQuantityLinesRemoved.Text = "0";
            // 
            // label3
            // 
            this.label3.Anchor = System.Windows.Forms.AnchorStyles.Right;
            this.label3.AutoSize = true;
            this.label3.Font = new System.Drawing.Font("Mongolian Baiti", 12F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label3.Location = new System.Drawing.Point(252, 270);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(43, 16);
            this.label3.TabIndex = 40;
            this.label3.Text = "Блоки";
            // 
            // lbQuantityBlocksRemoved
            // 
            this.lbQuantityBlocksRemoved.Anchor = System.Windows.Forms.AnchorStyles.Right;
            this.lbQuantityBlocksRemoved.AutoSize = true;
            this.lbQuantityBlocksRemoved.Font = new System.Drawing.Font("Mongolian Baiti", 12F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lbQuantityBlocksRemoved.Location = new System.Drawing.Point(252, 286);
            this.lbQuantityBlocksRemoved.Name = "lbQuantityBlocksRemoved";
            this.lbQuantityBlocksRemoved.Size = new System.Drawing.Size(16, 16);
            this.lbQuantityBlocksRemoved.TabIndex = 41;
            this.lbQuantityBlocksRemoved.Text = "0";
            // 
            // label6
            // 
            this.label6.Anchor = System.Windows.Forms.AnchorStyles.Right;
            this.label6.AutoSize = true;
            this.label6.Font = new System.Drawing.Font("Mongolian Baiti", 12F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label6.Location = new System.Drawing.Point(301, 238);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(58, 16);
            this.label6.TabIndex = 42;
            this.label6.Text = "Уровень";
            // 
            // lbLevel
            // 
            this.lbLevel.Anchor = System.Windows.Forms.AnchorStyles.Right;
            this.lbLevel.AutoSize = true;
            this.lbLevel.Font = new System.Drawing.Font("Mongolian Baiti", 12F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lbLevel.Location = new System.Drawing.Point(322, 254);
            this.lbLevel.Name = "lbLevel";
            this.lbLevel.Size = new System.Drawing.Size(16, 16);
            this.lbLevel.TabIndex = 43;
            this.lbLevel.Text = "0";
            // 
            // btnEndGame
            // 
            this.btnEndGame.Anchor = System.Windows.Forms.AnchorStyles.Right;
            this.btnEndGame.Location = new System.Drawing.Point(253, 326);
            this.btnEndGame.Name = "btnEndGame";
            this.btnEndGame.Size = new System.Drawing.Size(85, 35);
            this.btnEndGame.TabIndex = 44;
            this.btnEndGame.Text = "Закончить";
            this.btnEndGame.UseVisualStyleBackColor = true;
            this.btnEndGame.Click += new System.EventHandler(this.btnEndGame_Click);
            // 
            // panelWithScene
            // 
            this.panelWithScene.BackColor = System.Drawing.SystemColors.Control;
            this.panelWithScene.Controls.Add(this.pbScene);
            this.panelWithScene.Location = new System.Drawing.Point(12, 54);
            this.panelWithScene.Name = "panelWithScene";
            this.panelWithScene.Size = new System.Drawing.Size(224, 310);
            this.panelWithScene.TabIndex = 45;
            // 
            // label4
            // 
            this.label4.Anchor = System.Windows.Forms.AnchorStyles.Right;
            this.label4.AutoSize = true;
            this.label4.Font = new System.Drawing.Font("Mongolian Baiti", 12F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label4.Location = new System.Drawing.Point(251, 54);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(50, 16);
            this.label4.TabIndex = 46;
            this.label4.Text = "Лучший";
            // 
            // lbTopScore
            // 
            this.lbTopScore.Anchor = System.Windows.Forms.AnchorStyles.Right;
            this.lbTopScore.AutoSize = true;
            this.lbTopScore.Font = new System.Drawing.Font("Mongolian Baiti", 12F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lbTopScore.Location = new System.Drawing.Point(252, 70);
            this.lbTopScore.Name = "lbTopScore";
            this.lbTopScore.Size = new System.Drawing.Size(16, 16);
            this.lbTopScore.TabIndex = 47;
            this.lbTopScore.Text = "0";
            // 
            // MainGameForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(361, 377);
            this.Controls.Add(this.lbTopScore);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.panelWithScene);
            this.Controls.Add(this.btnEndGame);
            this.Controls.Add(this.lbLevel);
            this.Controls.Add(this.label6);
            this.Controls.Add(this.lbQuantityBlocksRemoved);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.lbQuantityLinesRemoved);
            this.Controls.Add(this.label7);
            this.Controls.Add(this.lbTime);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.pbNextShape);
            this.Controls.Add(this.lbScore);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.btn_inquiry);
            this.Controls.Add(this.btn_question);
            this.DoubleBuffered = true;
            this.Name = "MainGameForm";
            this.Text = "MainGameForm";
            this.FormClosing += new System.Windows.Forms.FormClosingEventHandler(this.MainGameForm_FormClosing);
            this.ResizeEnd += new System.EventHandler(this.MainGameForm_ResizeEnd);
            ((System.ComponentModel.ISupportInitialize)(this.pbScene)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pbNextShape)).EndInit();
            this.panelWithScene.ResumeLayout(false);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.PictureBox pbScene;
        private System.Windows.Forms.Button btn_question;
        private System.Windows.Forms.Button btn_inquiry;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label lbScore;
        private System.Windows.Forms.PictureBox pbNextShape;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Label lbTime;
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.Label lbQuantityLinesRemoved;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label lbQuantityBlocksRemoved;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.Label lbLevel;
        private System.Windows.Forms.Button btnEndGame;
        private System.Windows.Forms.Panel panelWithScene;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label lbTopScore;
    }
}