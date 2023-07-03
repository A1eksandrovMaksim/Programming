
namespace Tetris2.Forms.User
{
    partial class SoundSettingsForm
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
            this.btnGoHome = new System.Windows.Forms.Button();
            this.label1 = new System.Windows.Forms.Label();
            this.btn_question = new System.Windows.Forms.Button();
            this.btn_inquiry = new System.Windows.Forms.Button();
            this.btnSave = new System.Windows.Forms.Button();
            this.label2 = new System.Windows.Forms.Label();
            this.tbMusic = new System.Windows.Forms.TrackBar();
            this.label3 = new System.Windows.Forms.Label();
            this.tbEffects = new System.Windows.Forms.TrackBar();
            this.tbGeneral = new System.Windows.Forms.TrackBar();
            this.label4 = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.tbMusic)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.tbEffects)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.tbGeneral)).BeginInit();
            this.SuspendLayout();
            // 
            // btnGoHome
            // 
            this.btnGoHome.Location = new System.Drawing.Point(51, 12);
            this.btnGoHome.Name = "btnGoHome";
            this.btnGoHome.Size = new System.Drawing.Size(71, 36);
            this.btnGoHome.TabIndex = 41;
            this.btnGoHome.Text = "Меню";
            this.btnGoHome.UseVisualStyleBackColor = true;
            this.btnGoHome.Click += new System.EventHandler(this.btnGoHome_Click);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Mongolian Baiti", 18F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(138, 18);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(162, 25);
            this.label1.TabIndex = 40;
            this.label1.Text = "Настройка звука";
            // 
            // btn_question
            // 
            this.btn_question.Font = new System.Drawing.Font("High Tower Text", 18F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btn_question.Location = new System.Drawing.Point(12, 12);
            this.btn_question.Name = "btn_question";
            this.btn_question.Size = new System.Drawing.Size(33, 36);
            this.btn_question.TabIndex = 39;
            this.btn_question.Text = "?";
            this.btn_question.UseVisualStyleBackColor = true;
            this.btn_question.Click += new System.EventHandler(this.btn_question_Click);
            // 
            // btn_inquiry
            // 
            this.btn_inquiry.Font = new System.Drawing.Font("High Tower Text", 18F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btn_inquiry.Location = new System.Drawing.Point(307, 12);
            this.btn_inquiry.Name = "btn_inquiry";
            this.btn_inquiry.Size = new System.Drawing.Size(33, 36);
            this.btn_inquiry.TabIndex = 38;
            this.btn_inquiry.Text = "i";
            this.btn_inquiry.UseVisualStyleBackColor = true;
            this.btn_inquiry.Click += new System.EventHandler(this.btn_inquiry_Click);
            // 
            // btnSave
            // 
            this.btnSave.Font = new System.Drawing.Font("Mongolian Baiti", 14.25F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnSave.Location = new System.Drawing.Point(102, 313);
            this.btnSave.Name = "btnSave";
            this.btnSave.Size = new System.Drawing.Size(163, 34);
            this.btnSave.TabIndex = 42;
            this.btnSave.Text = "Сохранить настройки";
            this.btnSave.UseVisualStyleBackColor = true;
            this.btnSave.Click += new System.EventHandler(this.btnSave_Click);
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Mongolian Baiti", 15.75F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label2.Location = new System.Drawing.Point(149, 70);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(66, 23);
            this.label2.TabIndex = 43;
            this.label2.Text = "Музыка";
            // 
            // tbMusic
            // 
            this.tbMusic.Location = new System.Drawing.Point(12, 96);
            this.tbMusic.Maximum = 100;
            this.tbMusic.Name = "tbMusic";
            this.tbMusic.RightToLeftLayout = true;
            this.tbMusic.Size = new System.Drawing.Size(328, 45);
            this.tbMusic.TabIndex = 44;
            this.tbMusic.TickFrequency = 10;
            this.tbMusic.Value = 100;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Font = new System.Drawing.Font("Mongolian Baiti", 15.75F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label3.Location = new System.Drawing.Point(139, 144);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(89, 23);
            this.label3.TabIndex = 45;
            this.label3.Text = "Эффекты";
            // 
            // tbEffects
            // 
            this.tbEffects.Location = new System.Drawing.Point(12, 170);
            this.tbEffects.Maximum = 100;
            this.tbEffects.Name = "tbEffects";
            this.tbEffects.RightToLeftLayout = true;
            this.tbEffects.Size = new System.Drawing.Size(328, 45);
            this.tbEffects.TabIndex = 46;
            this.tbEffects.TickFrequency = 10;
            this.tbEffects.Value = 100;
            // 
            // tbGeneral
            // 
            this.tbGeneral.Location = new System.Drawing.Point(12, 244);
            this.tbGeneral.Maximum = 100;
            this.tbGeneral.Name = "tbGeneral";
            this.tbGeneral.RightToLeftLayout = true;
            this.tbGeneral.Size = new System.Drawing.Size(328, 45);
            this.tbGeneral.TabIndex = 48;
            this.tbGeneral.TickFrequency = 10;
            this.tbGeneral.Value = 75;
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Font = new System.Drawing.Font("Mongolian Baiti", 15.75F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label4.Location = new System.Drawing.Point(149, 218);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(62, 23);
            this.label4.TabIndex = 47;
            this.label4.Text = "Общий";
            // 
            // SoundSettingsForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(352, 377);
            this.Controls.Add(this.tbGeneral);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.tbEffects);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.tbMusic);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.btnSave);
            this.Controls.Add(this.btnGoHome);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.btn_question);
            this.Controls.Add(this.btn_inquiry);
            this.Name = "SoundSettingsForm";
            this.Text = "SoundSettingsForm";
            this.FormClosing += new System.Windows.Forms.FormClosingEventHandler(this.SoundSettingsForm_FormClosing);
            ((System.ComponentModel.ISupportInitialize)(this.tbMusic)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.tbEffects)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.tbGeneral)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button btnGoHome;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Button btn_question;
        private System.Windows.Forms.Button btn_inquiry;
        private System.Windows.Forms.Button btnSave;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.TrackBar tbMusic;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.TrackBar tbEffects;
        private System.Windows.Forms.TrackBar tbGeneral;
        private System.Windows.Forms.Label label4;
    }
}