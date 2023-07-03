
namespace Tetris2
{
    partial class EditeLevelForm
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
            this.btn_inquiry = new System.Windows.Forms.Button();
            this.btn_question = new System.Windows.Forms.Button();
            this.label2 = new System.Windows.Forms.Label();
            this.tbFallingSpeed = new System.Windows.Forms.TextBox();
            this.label6 = new System.Windows.Forms.Label();
            this.cbEnableNetMode = new System.Windows.Forms.CheckBox();
            this.label7 = new System.Windows.Forms.Label();
            this.tbPointsForLine = new System.Windows.Forms.TextBox();
            this.flpBlocks = new System.Windows.Forms.FlowLayoutPanel();
            this.label3 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.flpGlasses = new System.Windows.Forms.FlowLayoutPanel();
            this.btnAddBlock = new System.Windows.Forms.Button();
            this.btnDeleteBlock = new System.Windows.Forms.Button();
            this.btnEditBlock = new System.Windows.Forms.Button();
            this.btnEditGlass = new System.Windows.Forms.Button();
            this.btnDeleteGlass = new System.Windows.Forms.Button();
            this.btnAddGlass = new System.Windows.Forms.Button();
            this.btnSaveLevel = new System.Windows.Forms.Button();
            this.btnAddDiscription = new System.Windows.Forms.Button();
            this.label8 = new System.Windows.Forms.Label();
            this.tbNumberOfLevel = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.btnEditSublevels = new System.Windows.Forms.Button();
            this.lbSublevels = new System.Windows.Forms.Label();
            this.btnGoBack = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // btn_inquiry
            // 
            this.btn_inquiry.Font = new System.Drawing.Font("High Tower Text", 18F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btn_inquiry.Location = new System.Drawing.Point(307, 9);
            this.btn_inquiry.Name = "btn_inquiry";
            this.btn_inquiry.Size = new System.Drawing.Size(33, 36);
            this.btn_inquiry.TabIndex = 21;
            this.btn_inquiry.Text = "i";
            this.btn_inquiry.UseVisualStyleBackColor = true;
            this.btn_inquiry.Click += new System.EventHandler(this.btn_inquiry_Click);
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
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Mongolian Baiti", 11.25F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label2.Location = new System.Drawing.Point(85, 344);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(56, 16);
            this.label2.TabIndex = 24;
            this.label2.Text = "Скорость";
            // 
            // tbFallingSpeed
            // 
            this.tbFallingSpeed.Location = new System.Drawing.Point(147, 343);
            this.tbFallingSpeed.Name = "tbFallingSpeed";
            this.tbFallingSpeed.Size = new System.Drawing.Size(40, 20);
            this.tbFallingSpeed.TabIndex = 25;
            this.tbFallingSpeed.Text = "0,25";
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Font = new System.Drawing.Font("Mongolian Baiti", 11.25F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label6.Location = new System.Drawing.Point(12, 344);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(46, 16);
            this.label6.TabIndex = 32;
            this.label6.Text = "Сетка :";
            // 
            // cbEnableNetMode
            // 
            this.cbEnableNetMode.AutoSize = true;
            this.cbEnableNetMode.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.cbEnableNetMode.Location = new System.Drawing.Point(64, 345);
            this.cbEnableNetMode.Name = "cbEnableNetMode";
            this.cbEnableNetMode.Size = new System.Drawing.Size(15, 14);
            this.cbEnableNetMode.TabIndex = 33;
            this.cbEnableNetMode.UseVisualStyleBackColor = true;
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Font = new System.Drawing.Font("Mongolian Baiti", 11.25F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label7.Location = new System.Drawing.Point(190, 344);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(41, 16);
            this.label7.TabIndex = 34;
            this.label7.Text = "Очки :";
            // 
            // tbPointsForLine
            // 
            this.tbPointsForLine.Location = new System.Drawing.Point(234, 343);
            this.tbPointsForLine.Name = "tbPointsForLine";
            this.tbPointsForLine.Size = new System.Drawing.Size(89, 20);
            this.tbPointsForLine.TabIndex = 35;
            this.tbPointsForLine.Text = "10";
            // 
            // flpBlocks
            // 
            this.flpBlocks.AutoScroll = true;
            this.flpBlocks.FlowDirection = System.Windows.Forms.FlowDirection.BottomUp;
            this.flpBlocks.ImeMode = System.Windows.Forms.ImeMode.NoControl;
            this.flpBlocks.Location = new System.Drawing.Point(12, 70);
            this.flpBlocks.Name = "flpBlocks";
            this.flpBlocks.Size = new System.Drawing.Size(328, 93);
            this.flpBlocks.TabIndex = 36;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Font = new System.Drawing.Font("Mongolian Baiti", 11.25F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label3.Location = new System.Drawing.Point(11, 51);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(162, 16);
            this.label3.TabIndex = 38;
            this.label3.Text = "Доступные фигуры на уровне";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Font = new System.Drawing.Font("Mongolian Baiti", 11.25F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label4.Location = new System.Drawing.Point(6, 166);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(167, 16);
            this.label4.TabIndex = 40;
            this.label4.Text = "Доступные стаканы на уровне";
            // 
            // flpGlasses
            // 
            this.flpGlasses.AutoScroll = true;
            this.flpGlasses.FlowDirection = System.Windows.Forms.FlowDirection.BottomUp;
            this.flpGlasses.Location = new System.Drawing.Point(10, 185);
            this.flpGlasses.Name = "flpGlasses";
            this.flpGlasses.Size = new System.Drawing.Size(328, 48);
            this.flpGlasses.TabIndex = 39;
            // 
            // btnAddBlock
            // 
            this.btnAddBlock.Location = new System.Drawing.Point(10, 245);
            this.btnAddBlock.Name = "btnAddBlock";
            this.btnAddBlock.Size = new System.Drawing.Size(104, 24);
            this.btnAddBlock.TabIndex = 41;
            this.btnAddBlock.Text = "Добавить фигуру";
            this.btnAddBlock.UseVisualStyleBackColor = true;
            this.btnAddBlock.Click += new System.EventHandler(this.btnAddBlock_Click);
            // 
            // btnDeleteBlock
            // 
            this.btnDeleteBlock.Location = new System.Drawing.Point(10, 316);
            this.btnDeleteBlock.Name = "btnDeleteBlock";
            this.btnDeleteBlock.Size = new System.Drawing.Size(103, 23);
            this.btnDeleteBlock.TabIndex = 42;
            this.btnDeleteBlock.Text = "Удалить фигуру";
            this.btnDeleteBlock.UseVisualStyleBackColor = true;
            this.btnDeleteBlock.Click += new System.EventHandler(this.btnDeleteBlock_Click);
            // 
            // btnEditBlock
            // 
            this.btnEditBlock.Location = new System.Drawing.Point(9, 275);
            this.btnEditBlock.Name = "btnEditBlock";
            this.btnEditBlock.Size = new System.Drawing.Size(104, 35);
            this.btnEditBlock.TabIndex = 43;
            this.btnEditBlock.Text = "Редактировать фигуру";
            this.btnEditBlock.UseVisualStyleBackColor = true;
            this.btnEditBlock.Click += new System.EventHandler(this.btnEditBlock_Click);
            // 
            // btnEditGlass
            // 
            this.btnEditGlass.Location = new System.Drawing.Point(239, 304);
            this.btnEditGlass.Name = "btnEditGlass";
            this.btnEditGlass.Size = new System.Drawing.Size(101, 35);
            this.btnEditGlass.TabIndex = 46;
            this.btnEditGlass.Text = "Редактировать стакан";
            this.btnEditGlass.UseVisualStyleBackColor = true;
            this.btnEditGlass.Click += new System.EventHandler(this.btnEditGlass_Click);
            // 
            // btnDeleteGlass
            // 
            this.btnDeleteGlass.Location = new System.Drawing.Point(237, 275);
            this.btnDeleteGlass.Name = "btnDeleteGlass";
            this.btnDeleteGlass.Size = new System.Drawing.Size(103, 23);
            this.btnDeleteGlass.TabIndex = 45;
            this.btnDeleteGlass.Text = "Удалить стакан";
            this.btnDeleteGlass.UseVisualStyleBackColor = true;
            this.btnDeleteGlass.Click += new System.EventHandler(this.btnDeleteGlass_Click);
            // 
            // btnAddGlass
            // 
            this.btnAddGlass.Location = new System.Drawing.Point(237, 245);
            this.btnAddGlass.Name = "btnAddGlass";
            this.btnAddGlass.Size = new System.Drawing.Size(104, 24);
            this.btnAddGlass.TabIndex = 44;
            this.btnAddGlass.Text = "Добавить стакан";
            this.btnAddGlass.UseVisualStyleBackColor = true;
            this.btnAddGlass.Click += new System.EventHandler(this.btnAddGlass_Click);
            // 
            // btnSaveLevel
            // 
            this.btnSaveLevel.Font = new System.Drawing.Font("Mongolian Baiti", 11.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnSaveLevel.Location = new System.Drawing.Point(139, 245);
            this.btnSaveLevel.Name = "btnSaveLevel";
            this.btnSaveLevel.Size = new System.Drawing.Size(77, 40);
            this.btnSaveLevel.TabIndex = 47;
            this.btnSaveLevel.Text = "Сохранить Уровень";
            this.btnSaveLevel.UseVisualStyleBackColor = true;
            this.btnSaveLevel.Click += new System.EventHandler(this.btnSaveLevel_Click);
            // 
            // btnAddDiscription
            // 
            this.btnAddDiscription.Font = new System.Drawing.Font("Mongolian Baiti", 11.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnAddDiscription.Location = new System.Drawing.Point(127, 299);
            this.btnAddDiscription.Name = "btnAddDiscription";
            this.btnAddDiscription.Size = new System.Drawing.Size(104, 40);
            this.btnAddDiscription.TabIndex = 48;
            this.btnAddDiscription.Text = "Добавить описание уровня";
            this.btnAddDiscription.UseVisualStyleBackColor = true;
            this.btnAddDiscription.Click += new System.EventHandler(this.btnAddDiscription_Click);
            // 
            // label8
            // 
            this.label8.AutoSize = true;
            this.label8.Font = new System.Drawing.Font("Mongolian Baiti", 12F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Italic))), System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label8.Location = new System.Drawing.Point(130, 22);
            this.label8.Name = "label8";
            this.label8.Size = new System.Drawing.Size(113, 16);
            this.label8.TabIndex = 49;
            this.label8.Text = "Номер уровня :";
            // 
            // tbNumberOfLevel
            // 
            this.tbNumberOfLevel.Location = new System.Drawing.Point(249, 21);
            this.tbNumberOfLevel.Name = "tbNumberOfLevel";
            this.tbNumberOfLevel.Size = new System.Drawing.Size(45, 20);
            this.tbNumberOfLevel.TabIndex = 50;
            this.tbNumberOfLevel.Text = "1";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Mongolian Baiti", 11.25F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(7, 372);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(138, 16);
            this.label1.TabIndex = 51;
            this.label1.Text = "Количество подуровней :";
            // 
            // btnEditSublevels
            // 
            this.btnEditSublevels.Location = new System.Drawing.Point(173, 369);
            this.btnEditSublevels.Name = "btnEditSublevels";
            this.btnEditSublevels.Size = new System.Drawing.Size(150, 22);
            this.btnEditSublevels.TabIndex = 53;
            this.btnEditSublevels.Text = "Редактировать подуровни";
            this.btnEditSublevels.UseVisualStyleBackColor = true;
            this.btnEditSublevels.Click += new System.EventHandler(this.btnEditSublevels_Click);
            // 
            // lbSublevels
            // 
            this.lbSublevels.AutoSize = true;
            this.lbSublevels.BackColor = System.Drawing.SystemColors.Control;
            this.lbSublevels.Font = new System.Drawing.Font("Mongolian Baiti", 11.25F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lbSublevels.Location = new System.Drawing.Point(142, 372);
            this.lbSublevels.Name = "lbSublevels";
            this.lbSublevels.Size = new System.Drawing.Size(16, 16);
            this.lbSublevels.TabIndex = 54;
            this.lbSublevels.Text = "0";
            // 
            // btnGoBack
            // 
            this.btnGoBack.Location = new System.Drawing.Point(51, 12);
            this.btnGoBack.Name = "btnGoBack";
            this.btnGoBack.Size = new System.Drawing.Size(71, 36);
            this.btnGoBack.TabIndex = 55;
            this.btnGoBack.Text = "Назад";
            this.btnGoBack.UseVisualStyleBackColor = true;
            this.btnGoBack.Click += new System.EventHandler(this.btnGoBack_Click);
            // 
            // EditeLevelForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(352, 406);
            this.Controls.Add(this.btnAddDiscription);
            this.Controls.Add(this.btnGoBack);
            this.Controls.Add(this.lbSublevels);
            this.Controls.Add(this.btnEditSublevels);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.tbNumberOfLevel);
            this.Controls.Add(this.label8);
            this.Controls.Add(this.btnSaveLevel);
            this.Controls.Add(this.btnEditGlass);
            this.Controls.Add(this.btnDeleteGlass);
            this.Controls.Add(this.btnAddGlass);
            this.Controls.Add(this.btnEditBlock);
            this.Controls.Add(this.btnDeleteBlock);
            this.Controls.Add(this.btnAddBlock);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.flpGlasses);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.flpBlocks);
            this.Controls.Add(this.tbPointsForLine);
            this.Controls.Add(this.label7);
            this.Controls.Add(this.cbEnableNetMode);
            this.Controls.Add(this.label6);
            this.Controls.Add(this.tbFallingSpeed);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.btn_question);
            this.Controls.Add(this.btn_inquiry);
            this.Name = "EditeLevelForm";
            this.Text = "EditeLevelForm";
            this.FormClosing += new System.Windows.Forms.FormClosingEventHandler(this.EditeLevelForm_FormClosing);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button btn_inquiry;
        private System.Windows.Forms.Button btn_question;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.TextBox tbFallingSpeed;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.CheckBox cbEnableNetMode;
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.TextBox tbPointsForLine;
        private System.Windows.Forms.FlowLayoutPanel flpBlocks;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.FlowLayoutPanel flpGlasses;
        private System.Windows.Forms.Button btnAddBlock;
        private System.Windows.Forms.Button btnDeleteBlock;
        private System.Windows.Forms.Button btnEditBlock;
        private System.Windows.Forms.Button btnEditGlass;
        private System.Windows.Forms.Button btnDeleteGlass;
        private System.Windows.Forms.Button btnAddGlass;
        private System.Windows.Forms.Button btnSaveLevel;
        private System.Windows.Forms.Button btnAddDiscription;
        private System.Windows.Forms.Label label8;
        private System.Windows.Forms.TextBox tbNumberOfLevel;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Button btnEditSublevels;
        private System.Windows.Forms.Label lbSublevels;
        private System.Windows.Forms.Button btnGoBack;
    }
}