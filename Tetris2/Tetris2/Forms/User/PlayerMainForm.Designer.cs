
namespace Tetris2
{
    partial class PlayerMainForm
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
            System.Windows.Forms.DataGridViewCellStyle dataGridViewCellStyle1 = new System.Windows.Forms.DataGridViewCellStyle();
            System.Windows.Forms.DataGridViewCellStyle dataGridViewCellStyle2 = new System.Windows.Forms.DataGridViewCellStyle();
            System.Windows.Forms.DataGridViewCellStyle dataGridViewCellStyle5 = new System.Windows.Forms.DataGridViewCellStyle();
            System.Windows.Forms.DataGridViewCellStyle dataGridViewCellStyle6 = new System.Windows.Forms.DataGridViewCellStyle();
            System.Windows.Forms.DataGridViewCellStyle dataGridViewCellStyle7 = new System.Windows.Forms.DataGridViewCellStyle();
            System.Windows.Forms.DataGridViewCellStyle dataGridViewCellStyle3 = new System.Windows.Forms.DataGridViewCellStyle();
            System.Windows.Forms.DataGridViewCellStyle dataGridViewCellStyle4 = new System.Windows.Forms.DataGridViewCellStyle();
            this.label1 = new System.Windows.Forms.Label();
            this.btnStartGame = new System.Windows.Forms.Button();
            this.btn_question = new System.Windows.Forms.Button();
            this.btn_inquiry = new System.Windows.Forms.Button();
            this.btnStatistics = new System.Windows.Forms.Button();
            this.cbGameMode = new System.Windows.Forms.ComboBox();
            this.label2 = new System.Windows.Forms.Label();
            this.dgvLevels = new System.Windows.Forms.DataGridView();
            this.Level = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.clmnDescription = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.btnGoHome = new System.Windows.Forms.Button();
            this.cbNetMode = new System.Windows.Forms.CheckBox();
            this.label3 = new System.Windows.Forms.Label();
            this.cbSoundEnable = new System.Windows.Forms.CheckBox();
            this.btnSetSoundSettings = new System.Windows.Forms.Button();
            ((System.ComponentModel.ISupportInitialize)(this.dgvLevels)).BeginInit();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Mongolian Baiti", 18F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(146, 18);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(133, 25);
            this.label1.TabIndex = 26;
            this.label1.Text = "Меню Игрока";
            // 
            // btnStartGame
            // 
            this.btnStartGame.Font = new System.Drawing.Font("Mongolian Baiti", 14.25F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnStartGame.Location = new System.Drawing.Point(94, 331);
            this.btnStartGame.Name = "btnStartGame";
            this.btnStartGame.Size = new System.Drawing.Size(163, 34);
            this.btnStartGame.TabIndex = 23;
            this.btnStartGame.Text = "Начать игру";
            this.btnStartGame.UseVisualStyleBackColor = true;
            this.btnStartGame.Click += new System.EventHandler(this.btnStartGame_Click);
            // 
            // btn_question
            // 
            this.btn_question.Font = new System.Drawing.Font("High Tower Text", 18F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btn_question.Location = new System.Drawing.Point(12, 12);
            this.btn_question.Name = "btn_question";
            this.btn_question.Size = new System.Drawing.Size(33, 36);
            this.btn_question.TabIndex = 22;
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
            this.btn_inquiry.TabIndex = 21;
            this.btn_inquiry.Text = "i";
            this.btn_inquiry.UseVisualStyleBackColor = true;
            this.btn_inquiry.Click += new System.EventHandler(this.btn_inquiry_Click);
            // 
            // btnStatistics
            // 
            this.btnStatistics.Font = new System.Drawing.Font("Mongolian Baiti", 14.25F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnStatistics.Location = new System.Drawing.Point(12, 54);
            this.btnStatistics.Name = "btnStatistics";
            this.btnStatistics.Size = new System.Drawing.Size(110, 29);
            this.btnStatistics.TabIndex = 29;
            this.btnStatistics.Text = "Статистика";
            this.btnStatistics.UseVisualStyleBackColor = true;
            this.btnStatistics.Click += new System.EventHandler(this.btnStatistics_Click);
            // 
            // cbGameMode
            // 
            this.cbGameMode.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cbGameMode.Font = new System.Drawing.Font("Mongolian Baiti", 11.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.cbGameMode.ImeMode = System.Windows.Forms.ImeMode.Off;
            this.cbGameMode.Items.AddRange(new object[] {
            "Time",
            "Free",
            "Points",
            "Both"});
            this.cbGameMode.Location = new System.Drawing.Point(250, 85);
            this.cbGameMode.Name = "cbGameMode";
            this.cbGameMode.Size = new System.Drawing.Size(90, 24);
            this.cbGameMode.TabIndex = 30;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Mongolian Baiti", 14.25F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label2.Location = new System.Drawing.Point(246, 58);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(98, 20);
            this.label2.TabIndex = 31;
            this.label2.Text = "Режим игры :";
            // 
            // dgvLevels
            // 
            this.dgvLevels.AllowUserToAddRows = false;
            dataGridViewCellStyle1.Font = new System.Drawing.Font("Mongolian Baiti", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.dgvLevels.AlternatingRowsDefaultCellStyle = dataGridViewCellStyle1;
            dataGridViewCellStyle2.Alignment = System.Windows.Forms.DataGridViewContentAlignment.MiddleCenter;
            dataGridViewCellStyle2.BackColor = System.Drawing.SystemColors.Control;
            dataGridViewCellStyle2.Font = new System.Drawing.Font("Mongolian Baiti", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            dataGridViewCellStyle2.ForeColor = System.Drawing.SystemColors.WindowText;
            dataGridViewCellStyle2.SelectionBackColor = System.Drawing.SystemColors.Highlight;
            dataGridViewCellStyle2.SelectionForeColor = System.Drawing.SystemColors.HighlightText;
            dataGridViewCellStyle2.WrapMode = System.Windows.Forms.DataGridViewTriState.True;
            this.dgvLevels.ColumnHeadersDefaultCellStyle = dataGridViewCellStyle2;
            this.dgvLevels.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dgvLevels.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.Level,
            this.clmnDescription});
            dataGridViewCellStyle5.Alignment = System.Windows.Forms.DataGridViewContentAlignment.MiddleLeft;
            dataGridViewCellStyle5.BackColor = System.Drawing.SystemColors.Window;
            dataGridViewCellStyle5.Font = new System.Drawing.Font("Mongolian Baiti", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            dataGridViewCellStyle5.ForeColor = System.Drawing.SystemColors.ControlText;
            dataGridViewCellStyle5.SelectionBackColor = System.Drawing.SystemColors.Highlight;
            dataGridViewCellStyle5.SelectionForeColor = System.Drawing.SystemColors.HighlightText;
            dataGridViewCellStyle5.WrapMode = System.Windows.Forms.DataGridViewTriState.False;
            this.dgvLevels.DefaultCellStyle = dataGridViewCellStyle5;
            this.dgvLevels.Location = new System.Drawing.Point(12, 115);
            this.dgvLevels.MultiSelect = false;
            this.dgvLevels.Name = "dgvLevels";
            this.dgvLevels.ReadOnly = true;
            dataGridViewCellStyle6.Alignment = System.Windows.Forms.DataGridViewContentAlignment.MiddleCenter;
            dataGridViewCellStyle6.BackColor = System.Drawing.SystemColors.Control;
            dataGridViewCellStyle6.Font = new System.Drawing.Font("Mongolian Baiti", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            dataGridViewCellStyle6.ForeColor = System.Drawing.SystemColors.WindowText;
            dataGridViewCellStyle6.SelectionBackColor = System.Drawing.SystemColors.Highlight;
            dataGridViewCellStyle6.SelectionForeColor = System.Drawing.SystemColors.HighlightText;
            dataGridViewCellStyle6.WrapMode = System.Windows.Forms.DataGridViewTriState.True;
            this.dgvLevels.RowHeadersDefaultCellStyle = dataGridViewCellStyle6;
            this.dgvLevels.RowHeadersVisible = false;
            dataGridViewCellStyle7.Alignment = System.Windows.Forms.DataGridViewContentAlignment.MiddleCenter;
            dataGridViewCellStyle7.Font = new System.Drawing.Font("Mongolian Baiti", 11.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.dgvLevels.RowsDefaultCellStyle = dataGridViewCellStyle7;
            this.dgvLevels.RowTemplate.Resizable = System.Windows.Forms.DataGridViewTriState.False;
            this.dgvLevels.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect;
            this.dgvLevels.Size = new System.Drawing.Size(328, 210);
            this.dgvLevels.TabIndex = 34;
            this.dgvLevels.Paint += new System.Windows.Forms.PaintEventHandler(this.dgvLevels_Paint);
            // 
            // Level
            // 
            dataGridViewCellStyle3.Alignment = System.Windows.Forms.DataGridViewContentAlignment.MiddleCenter;
            dataGridViewCellStyle3.Font = new System.Drawing.Font("Mongolian Baiti", 12F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Level.DefaultCellStyle = dataGridViewCellStyle3;
            this.Level.HeaderText = "Уровень";
            this.Level.Name = "Level";
            this.Level.ReadOnly = true;
            this.Level.Resizable = System.Windows.Forms.DataGridViewTriState.False;
            this.Level.Width = 80;
            // 
            // clmnDescription
            // 
            this.clmnDescription.AutoSizeMode = System.Windows.Forms.DataGridViewAutoSizeColumnMode.Fill;
            dataGridViewCellStyle4.Alignment = System.Windows.Forms.DataGridViewContentAlignment.MiddleCenter;
            dataGridViewCellStyle4.Font = new System.Drawing.Font("Mongolian Baiti", 14.25F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.clmnDescription.DefaultCellStyle = dataGridViewCellStyle4;
            this.clmnDescription.HeaderText = "Описание";
            this.clmnDescription.Name = "clmnDescription";
            this.clmnDescription.ReadOnly = true;
            this.clmnDescription.Resizable = System.Windows.Forms.DataGridViewTriState.False;
            // 
            // btnGoHome
            // 
            this.btnGoHome.Location = new System.Drawing.Point(51, 12);
            this.btnGoHome.Name = "btnGoHome";
            this.btnGoHome.Size = new System.Drawing.Size(71, 36);
            this.btnGoHome.TabIndex = 35;
            this.btnGoHome.Text = "Меню";
            this.btnGoHome.UseVisualStyleBackColor = true;
            this.btnGoHome.Click += new System.EventHandler(this.btnGoHome_Click);
            // 
            // cbNetMode
            // 
            this.cbNetMode.AutoSize = true;
            this.cbNetMode.Enabled = false;
            this.cbNetMode.Font = new System.Drawing.Font("Mongolian Baiti", 12F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.cbNetMode.Location = new System.Drawing.Point(12, 89);
            this.cbNetMode.Name = "cbNetMode";
            this.cbNetMode.Size = new System.Drawing.Size(120, 20);
            this.cbNetMode.TabIndex = 36;
            this.cbNetMode.Text = "Добавить сетку";
            this.cbNetMode.UseVisualStyleBackColor = true;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Font = new System.Drawing.Font("Mongolian Baiti", 14.25F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label3.Location = new System.Drawing.Point(139, 43);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(49, 20);
            this.label3.TabIndex = 37;
            this.label3.Text = "Звук :";
            // 
            // cbSoundEnable
            // 
            this.cbSoundEnable.AutoSize = true;
            this.cbSoundEnable.Checked = true;
            this.cbSoundEnable.CheckState = System.Windows.Forms.CheckState.Checked;
            this.cbSoundEnable.Location = new System.Drawing.Point(203, 48);
            this.cbSoundEnable.Name = "cbSoundEnable";
            this.cbSoundEnable.Size = new System.Drawing.Size(15, 14);
            this.cbSoundEnable.TabIndex = 38;
            this.cbSoundEnable.UseVisualStyleBackColor = true;
            // 
            // btnSetSoundSettings
            // 
            this.btnSetSoundSettings.Location = new System.Drawing.Point(143, 68);
            this.btnSetSoundSettings.Name = "btnSetSoundSettings";
            this.btnSetSoundSettings.Size = new System.Drawing.Size(75, 32);
            this.btnSetSoundSettings.TabIndex = 39;
            this.btnSetSoundSettings.Text = "настроить";
            this.btnSetSoundSettings.UseVisualStyleBackColor = true;
            this.btnSetSoundSettings.Click += new System.EventHandler(this.btnSetSoundSettings_Click);
            // 
            // PlayerMainForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(352, 377);
            this.Controls.Add(this.btnSetSoundSettings);
            this.Controls.Add(this.cbSoundEnable);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.cbNetMode);
            this.Controls.Add(this.btnGoHome);
            this.Controls.Add(this.dgvLevels);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.cbGameMode);
            this.Controls.Add(this.btnStatistics);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.btnStartGame);
            this.Controls.Add(this.btn_question);
            this.Controls.Add(this.btn_inquiry);
            this.Name = "PlayerMainForm";
            this.Text = "PlayerMainForm";
            this.FormClosing += new System.Windows.Forms.FormClosingEventHandler(this.PlayerMainForm_FormClosing);
            ((System.ComponentModel.ISupportInitialize)(this.dgvLevels)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Button btnStartGame;
        private System.Windows.Forms.Button btn_question;
        private System.Windows.Forms.Button btn_inquiry;
        private System.Windows.Forms.Button btnStatistics;
        private System.Windows.Forms.ComboBox cbGameMode;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.DataGridView dgvLevels;
        private System.Windows.Forms.DataGridViewTextBoxColumn Level;
        private System.Windows.Forms.DataGridViewTextBoxColumn clmnDescription;
        private System.Windows.Forms.Button btnGoHome;
        private System.Windows.Forms.CheckBox cbNetMode;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.CheckBox cbSoundEnable;
        private System.Windows.Forms.Button btnSetSoundSettings;
    }
}