
namespace Tetris2.Forms.User
{
    partial class TheEndOfGameForm
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
            this.btnOk = new System.Windows.Forms.Button();
            this.lbLines = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.lbTime = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.lbScore = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.lbBestTime = new System.Windows.Forms.Label();
            this.lbBestScore = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.lbBlocks = new System.Windows.Forms.Label();
            this.label7 = new System.Windows.Forms.Label();
            this.lbLevel = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // btnOk
            // 
            this.btnOk.Font = new System.Drawing.Font("Mongolian Baiti", 14.25F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnOk.Location = new System.Drawing.Point(81, 295);
            this.btnOk.Name = "btnOk";
            this.btnOk.Size = new System.Drawing.Size(189, 41);
            this.btnOk.TabIndex = 49;
            this.btnOk.Text = "ОК";
            this.btnOk.UseVisualStyleBackColor = true;
            this.btnOk.Click += new System.EventHandler(this.btnOk_Click);
            // 
            // lbLines
            // 
            this.lbLines.AutoSize = true;
            this.lbLines.Font = new System.Drawing.Font("Mongolian Baiti", 14.25F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lbLines.Location = new System.Drawing.Point(108, 190);
            this.lbLines.Name = "lbLines";
            this.lbLines.Size = new System.Drawing.Size(19, 20);
            this.lbLines.TabIndex = 48;
            this.lbLines.Text = "0";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Font = new System.Drawing.Font("Mongolian Baiti", 14.25F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label3.Location = new System.Drawing.Point(21, 160);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(200, 20);
            this.label3.TabIndex = 47;
            this.label3.Text = "Количество убранных линий";
            // 
            // lbTime
            // 
            this.lbTime.AutoSize = true;
            this.lbTime.Font = new System.Drawing.Font("Mongolian Baiti", 14.25F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lbTime.Location = new System.Drawing.Point(209, 101);
            this.lbTime.Name = "lbTime";
            this.lbTime.Size = new System.Drawing.Size(104, 20);
            this.lbTime.TabIndex = 46;
            this.lbTime.Text = "00:00:00:00";
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Font = new System.Drawing.Font("Mongolian Baiti", 14.25F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label5.Location = new System.Drawing.Point(234, 81);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(56, 20);
            this.label5.TabIndex = 45;
            this.label5.Text = "Время:";
            // 
            // lbScore
            // 
            this.lbScore.AutoSize = true;
            this.lbScore.Font = new System.Drawing.Font("Mongolian Baiti", 14.25F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lbScore.Location = new System.Drawing.Point(73, 101);
            this.lbScore.Name = "lbScore";
            this.lbScore.Size = new System.Drawing.Size(19, 20);
            this.lbScore.TabIndex = 44;
            this.lbScore.Text = "0";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Mongolian Baiti", 14.25F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label2.Location = new System.Drawing.Point(21, 101);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(46, 20);
            this.label2.TabIndex = 43;
            this.label2.Text = "Счёт:";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Mongolian Baiti", 20.25F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(95, 29);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(154, 29);
            this.label1.TabIndex = 42;
            this.label1.Text = "Конец Игры";
            // 
            // lbBestTime
            // 
            this.lbBestTime.AutoSize = true;
            this.lbBestTime.Font = new System.Drawing.Font("Mongolian Baiti", 14.25F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lbBestTime.ForeColor = System.Drawing.Color.DarkGreen;
            this.lbBestTime.Location = new System.Drawing.Point(209, 121);
            this.lbBestTime.Name = "lbBestTime";
            this.lbBestTime.Size = new System.Drawing.Size(106, 20);
            this.lbBestTime.TabIndex = 50;
            this.lbBestTime.Text = "Лучшее время";
            this.lbBestTime.Visible = false;
            // 
            // lbBestScore
            // 
            this.lbBestScore.AutoSize = true;
            this.lbBestScore.Font = new System.Drawing.Font("Mongolian Baiti", 14.25F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lbBestScore.ForeColor = System.Drawing.Color.DarkGreen;
            this.lbBestScore.Location = new System.Drawing.Point(31, 121);
            this.lbBestScore.Name = "lbBestScore";
            this.lbBestScore.Size = new System.Drawing.Size(96, 20);
            this.lbBestScore.TabIndex = 51;
            this.lbBestScore.Text = "Лучший счёт";
            this.lbBestScore.Visible = false;
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Font = new System.Drawing.Font("Mongolian Baiti", 14.25F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label4.Location = new System.Drawing.Point(21, 210);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(198, 20);
            this.label4.TabIndex = 52;
            this.label4.Text = "Количество упавших блоков";
            // 
            // lbBlocks
            // 
            this.lbBlocks.AutoSize = true;
            this.lbBlocks.Font = new System.Drawing.Font("Mongolian Baiti", 14.25F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lbBlocks.Location = new System.Drawing.Point(108, 244);
            this.lbBlocks.Name = "lbBlocks";
            this.lbBlocks.Size = new System.Drawing.Size(19, 20);
            this.lbBlocks.TabIndex = 53;
            this.lbBlocks.Text = "0";
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Font = new System.Drawing.Font("Mongolian Baiti", 14.25F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label7.Location = new System.Drawing.Point(268, 178);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(64, 20);
            this.label7.TabIndex = 54;
            this.label7.Text = "Уровень";
            // 
            // lbLevel
            // 
            this.lbLevel.AutoSize = true;
            this.lbLevel.Font = new System.Drawing.Font("Mongolian Baiti", 14.25F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lbLevel.Location = new System.Drawing.Point(285, 198);
            this.lbLevel.Name = "lbLevel";
            this.lbLevel.Size = new System.Drawing.Size(19, 20);
            this.lbLevel.TabIndex = 55;
            this.lbLevel.Text = "0";
            // 
            // TheEndOfGameForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(352, 377);
            this.Controls.Add(this.lbLevel);
            this.Controls.Add(this.label7);
            this.Controls.Add(this.lbBlocks);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.lbBestScore);
            this.Controls.Add(this.lbBestTime);
            this.Controls.Add(this.btnOk);
            this.Controls.Add(this.lbLines);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.lbTime);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.lbScore);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Name = "TheEndOfGameForm";
            this.Text = "TheEndOfGameForm";
            this.FormClosing += new System.Windows.Forms.FormClosingEventHandler(this.TheEndOfGameForm_FormClosing);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button btnOk;
        private System.Windows.Forms.Label lbLines;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label lbTime;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Label lbScore;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label lbBestTime;
        private System.Windows.Forms.Label lbBestScore;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label lbBlocks;
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.Label lbLevel;
    }
}