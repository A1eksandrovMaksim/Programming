using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using Tetris2.Classes;
using Tetris2.Forms.Admin.Editors.BlockEditor;
using Tetris2.Forms.Admin.Editors.GlassEditor;
using Tetris2.Forms.HelpForms;
using Tetris2.Forms.User;
using WMPLib;

namespace Tetris2
{
    public partial class MainGameForm : Form
    {
        private string user_id;
        private Shape currentShape;
        private Shape nextShape;
        private int mapHeight;
        private Timer timer1;
        private int mapWidth;
        private int[,] map;
        private int sizeSquareInMap;
        private Level level;
        private bool netMode;
        private string gameMode;
        private int linesRemoved = 0;
        private int blocksRemoved = 0;
        private int levelNumber = 1;
        private long score = 0;
        private DateTime startTime;
        private DateTime timeOfLastTick;
        private string currentSongURL;
        private double currentPlayerPosition;
        private double falling_speed;
        private WindowsMediaPlayer backgroundPlayer;
        private WindowsMediaPlayer effectsPlayer;
        private PlayerMainForm pmf;
        private string[] treck_list;
        private bool isFirstStepIntoUpdate = true;
        private int lastResizedHeight;
        private int lastResizedWidth;
        private int effectVolume;
        private int arreyOfBrushesLength = 24;
        private int backgroundValume;

        private string pathResources = @"C:\Users\Admin\Desktop\Home work\6403\7 семестр\ТПИВС\Tetris2\Tetris2\Resources\";


        public MainGameForm(Level _level, bool _netMode, string _gameMode,
            string _user_id, string topScore, int _effectVolume, int _backgroundValume, PlayerMainForm _pmf)
        {
            InitializeComponent();
            this.Show();
            panelWithScene.Focus();
            level = _level;
            lbTopScore.Text = topScore;
            netMode =_netMode;
            gameMode = _gameMode;
            user_id = _user_id;
            backgroundValume = _backgroundValume;
            effectVolume = _effectVolume;
            pmf = _pmf;
            lastResizedHeight = this.Size.Height;
            lastResizedWidth = this.Size.Width;
            falling_speed = level.getFallingSpeed();
            Init();
        }

        private void initMediaPlayer()
        {
            backgroundPlayer = new WindowsMediaPlayer();
            backgroundPlayer.settings.autoStart = false;
            backgroundPlayer.settings.volume = backgroundValume;
            effectsPlayer = new WindowsMediaPlayer();
            effectsPlayer.settings.autoStart = false;
            effectsPlayer.settings.volume = effectVolume;


            treck_list = new string[14];
            treck_list[0] = pathResources + "BackgroundSound_1.mp3";
            treck_list[1] = pathResources + "BackgroundSound_2.mp3";
            treck_list[2] = pathResources + "BackgroundSound_3.mp3";
            treck_list[3] = pathResources + "BackgroundSound_4.mp3";
            treck_list[4] = pathResources + "BackgroundSound_5.mp3";
            treck_list[5] = pathResources + "BackgroundSound_6.mp3";
            treck_list[6] = pathResources + "BackgroundSound_7.mp3";
            treck_list[7] = pathResources + "BackgroundSound_8.mp3";
            treck_list[8] = pathResources + "BackgroundSound_9.mp3";
            treck_list[9] = pathResources + "BackgroundSound_10.mp3";
            treck_list[10] = pathResources + "BackgroundSound_11.mp3";
            treck_list[11] = pathResources + "BackgroundSound_12.mp3";
            treck_list[12] = pathResources + "BackgroundSound_13.mp3";
            treck_list[13] = pathResources + "BackgroundSound_14.mp3";

            selectNextBackgroundSong();
        }
        
        private void selectNextBackgroundSong()
        {
            if(backgroundPlayer.playState == WMPPlayState.wmppsUndefined || backgroundPlayer.playState == WMPPlayState.wmppsStopped)
            {
                if(currentPlayerPosition != 0)
                {
                    backgroundPlayer.URL = currentSongURL;
                    backgroundPlayer.controls.currentPosition = currentPlayerPosition;
                    backgroundPlayer.controls.play();
                    currentPlayerPosition = 0;
                }
                else
                {
                    backgroundPlayer.URL = treck_list.ElementAt(new Random().Next(0, treck_list.Length - 1));
                    backgroundPlayer.controls.play();
                }
            }
        }

        private void Init()
        {
            initMediaPlayer();
            timeOfLastTick = startTime = DateTime.Now;
            setMap();
            setSizeSquareInMap();
            setCurrentShape();
            pbScene.Invalidate();
            panelWithScene.KeyDown += new KeyEventHandler(keyFunc);
            timer1 = new Timer();
            timer1.Interval = 10;
            timer1.Tick += new EventHandler(update);
            timer1.Start();
        }

        private Brush getBrush(int index)
        {
            switch(index){
                case 1:
                    return Brushes.Blue;
                case 2:
                    return Brushes.Green;
                case 3:
                    return Brushes.DeepPink;
                case 4:
                    return Brushes.Violet;
                case 5:
                    return Brushes.DarkKhaki;
                case 6:
                    return Brushes.Red;
                case 7:
                    return Brushes.Orange;
                case 8:
                    return Brushes.Coral;
                case 9:
                    return Brushes.Gold;
                case 10:
                    return Brushes.IndianRed;
                case 11:
                    return Brushes.Maroon;
                case 12:
                    return Brushes.Olive;
                case 13:
                    return Brushes.Indigo;
                case 14:
                    return Brushes.Gray;
                case 15:
                    return Brushes.SlateBlue;
                case 16:
                    return Brushes.GreenYellow;
                case 17:
                    return Brushes.Chocolate;
                case 18:
                    return Brushes.Salmon;
                case 19:
                    return Brushes.DarkSlateGray;
                case 20:
                    return Brushes.DarkSlateBlue;
                case 21:
                    return Brushes.DarkSlateGray;
                case 22:
                    return Brushes.DarkSeaGreen;
                case 23:
                    return Brushes.DarkKhaki;
                case 24:
                    return Brushes.DarkOrange;

            }
            return Brushes.Black;
        }

        private void keyFunc(object sender, KeyEventArgs e)
        {
            ResetArea();
            int q_nodes = currentShape.getQuantityNodes();

            switch (e.KeyCode)
            {
                case Keys.Q:
                    if (!CollideWhenRotate(false))
                    {
                        currentShape.rotateLeft();
                        effectsPlayer.URL = pathResources + "rotate.mp3";
                    }
                    break;
                case Keys.E:
                    if (!CollideWhenRotate(true))
                    {
                        currentShape.rotateRight();
                        effectsPlayer.URL = pathResources + "rotate.mp3";
                    }
                    break;
                case Keys.Space:
                    effectsPlayer.URL = pathResources + "fastFalling.mp3";
                    while (!Collide())
                    {
                        currentShape.moveDown();
                    }
                    Merge();
                    setCurrentShape();
                    if (CollideInStart())
                    {
                        inTheEndOfGame();
                        return;
                    }
                    timeOfLastTick = DateTime.Now;
                    score += q_nodes;
                    break;
                case Keys.S:
                    if (!Collide())
                    {
                        effectsPlayer.URL = pathResources + "blockFallingDown.mp3";
                        currentShape.moveDown();
                        timeOfLastTick = DateTime.Now;
                    }
                    else
                    {
                        Merge();
                        setCurrentShape();
                        if (CollideInStart())
                        {
                            inTheEndOfGame();
                            return;
                        }
                        score += q_nodes;
                        effectsPlayer.URL = pathResources + "blockFell.mp3";
                    }
                    break;
                case Keys.D:
                    if (!CollideHorizontral(true))
                    {
                        effectsPlayer.URL = pathResources + "shift.mp3";
                        currentShape.moveRight();
                    }
                    break;
                case Keys.A:
                    if (!CollideHorizontral(false))
                    {
                        effectsPlayer.URL = pathResources + "shift.mp3";
                        currentShape.moveLeft();
                    } 
                    break;
                default:
                    return;

            }

            effectsPlayer.controls.stop();
            effectsPlayer.controls.play();

            Merge();
            pbScene.Invalidate();
        }

        private void setMap()
        {
            foreach(Glass glass in level.getGlasses())
            {
                if (glass.checkInGame())
                {
                    mapHeight = glass.getHeight();
                    mapWidth = glass.getWidth();
                    map = new int[mapHeight, mapWidth];
                    return;
                }  
            }
        }

        private void setSizeSquareInMap()
        {
            if (pbScene.Size.Width / mapWidth > pbScene.Size.Height / mapHeight)
                sizeSquareInMap = (pbScene.Size.Height - 1) / mapHeight;
            else
                sizeSquareInMap = (pbScene.Size.Width - 1) / mapWidth;
        }

        private void setCurrentShape()
        {
            Random r = new Random();
            if (currentShape == null)
            {
                Block startBlock = level.getBlocks().ElementAt(r.Next(0, level.getBlocks().Count));
                currentShape = new Shape((mapWidth/2)%2==0?(mapWidth/2)-1:(mapWidth/2) - startBlock.getBlockWidth() / 2, 0, mapHeight, mapWidth,
                r.Next(1, arreyOfBrushesLength+1), startBlock);
            }
            else
            {
                ++blocksRemoved;
                currentShape = nextShape;
            }

            while (true)
            {
                Block nextBlock = level.getBlocks().ElementAt(r.Next(0, level.getBlocks().Count));
                nextShape = new Shape((mapWidth / 2) % 2 == 0 ? (mapWidth / 2) - 1 : (mapWidth / 2) - nextBlock.getBlockWidth() / 2
                    , 0, mapHeight, mapWidth,
                    r.Next(1, arreyOfBrushesLength + 1), nextBlock);

                bool isUnique = false;
                if (nextShape.sizeMatrix != currentShape.sizeMatrix)
                    break;
                for(int i = 0; i < nextShape.sizeMatrix; ++i)
                {
                    for (int j = 0; j < nextShape.sizeMatrix; ++j)
                    {
                        if (nextShape.matrix[i, j] != 0 && currentShape.matrix[i, j] == 0 ||
                            nextShape.matrix[i, j] == 0 && currentShape.matrix[i, j] != 0)
                        {
                            isUnique = true;
                            break;
                        }
                    }
                    if (isUnique)
                        break;
                }
                if (isUnique)
                    break;
            }
            DrawNextShape();
        }

        private void showResults()
        {
            long tick = DateTime.Now.Ticks - startTime.Ticks;
            DateTime stopTick = new DateTime();
            stopTick = stopTick.AddTicks(tick);
            lbTime.Text = String.Format("{0:HH:mm:ss:ff}", stopTick);
            lbQuantityBlocksRemoved.Text = blocksRemoved.ToString();
            lbQuantityLinesRemoved.Text = linesRemoved.ToString();
            lbScore.Text = score.ToString();
            if (score != 0)
                falling_speed = level.getFallingSpeed() + ((60 - level.getFallingSpeed()) / 
                    ((level.getSublevels().ElementAt(level.getSublevels().Count-1).getLimitPoints()) * 2)) * score;

            int currentLevel = levelNumber;
            levelNumber = 0;
            for(int i = 0; i < level.getSublevels().Count; ++i)
            {
                if(level.getSublevels().ElementAt(i).getLimitPoints() > score)
                    break;
                ++levelNumber;
            }

            lbLevel.Text = levelNumber.ToString();
            if(currentLevel != levelNumber)
            {
                currentSongURL = backgroundPlayer.URL;
                currentPlayerPosition = backgroundPlayer.controls.currentPosition;
                backgroundPlayer.controls.stop();
                backgroundPlayer.URL = pathResources + "nextLevel.mp3";
                backgroundPlayer.controls.play();
            }

        }

        private void SliceMap()
        {
            int thereLinesRemove = 0;
            for (int i = 0; i < mapHeight; ++i)
            {
                bool isFullLine = true;
                for (int j = 0; j < mapWidth; ++j)
                {
                    if (map[i, j] == 0)
                    {
                        isFullLine = false;
                        break;
                    }

                }
                if (isFullLine)
                {
                    ++thereLinesRemove;
                    linesRemoved++;
                    for (int m = i - 1; m >= 0; --m)
                    {
                        for (int n = 0; n < mapWidth; ++n)
                        {
                            map[m + 1, n] = map[m, n];
                        }
                    }
                }
            }


            if (thereLinesRemove == 1)
            {
                effectsPlayer.URL = pathResources + "deleteLine.mp3";
                score += level.getpointsForLine();
            }
            if (thereLinesRemove == 2)
            {
                effectsPlayer.URL = pathResources + "doubleline.mp3";
                score += level.getpointsForLine() * 3;
            }
            if (thereLinesRemove == 3)
            {
                effectsPlayer.URL = pathResources + "tripleline.mp3";
                score += level.getpointsForLine() * 7;
            }
            if (thereLinesRemove == 4)
            {
                score += level.getpointsForLine() * 15;
                effectsPlayer.URL = pathResources + "gettetris.mp3";
            }

            if (thereLinesRemove != 0)
            {
                effectsPlayer.controls.stop();
                effectsPlayer.controls.play();
            }

        }

        private void update(object sender, EventArgs e)
        {
            if (isFirstStepIntoUpdate)
            {
                DrawNextShape();
                isFirstStepIntoUpdate = false;
            }

            selectNextBackgroundSong();
            ResetArea();
            SliceMap();
            showResults();

            if((DateTime.Now.Ticks - timeOfLastTick.Ticks) / 10000000.0 > (1 / falling_speed))
            {
                panelWithScene.Focus();
                timeOfLastTick = DateTime.Now;
                if (!Collide())
                {
                    currentShape.moveDown();
                    effectsPlayer.URL = pathResources + "blockFallingDown.mp3";
                    effectsPlayer.controls.stop();
                    effectsPlayer.controls.play();
                }
                else if (Collide())
                {
                    int q_nodes = currentShape.getQuantityNodes();
                    Merge();
                    setCurrentShape();
                    if (CollideInStart())
                    {
                        inTheEndOfGame();
                        return;
                    }
                    score += q_nodes;
                    effectsPlayer.URL = pathResources + "blockFell.mp3";
                    effectsPlayer.controls.stop();
                    effectsPlayer.controls.play();
                }
            }


            Merge();
            pbScene.Invalidate();
        }

        private void Merge()
        {
            for (int j = currentShape.y; j < currentShape.y + currentShape.sizeMatrix; ++j)
            {
                for (int i = currentShape.x; i < currentShape.x + currentShape.sizeMatrix; ++i)
                {
                    if (currentShape.matrix[j - currentShape.y, i - currentShape.x] != 0)
                        map[j, i] = currentShape.matrix[j - currentShape.y, i - currentShape.x];
                }
            }
        }

        private bool CollideInStart()
        {
            for (int i = currentShape.y; i < currentShape.y + currentShape.sizeMatrix; ++i)
            {
                for (int j = currentShape.x; j < currentShape.x + currentShape.sizeMatrix; ++j)
                {
                    if (currentShape.matrix[i - currentShape.y, j - currentShape.x] != 0)
                    {
                        if (map[i, j] != 0)
                            return true;
                    }
                }
            }
            return false;
        }

        private bool Collide()
        {
            for (int i = currentShape.y + currentShape.sizeMatrix - 1; i >= currentShape.y; --i)
            {
                for (int j = currentShape.x; j < currentShape.x + currentShape.sizeMatrix; ++j)
                {
                    if (currentShape.matrix[i - currentShape.y, j - currentShape.x] != 0)
                    {
                        if (i + 1 == mapHeight)
                            return true;
                        if (map[i + 1, j] != 0)
                            return true;
                    }
                }
            }
            return false;
        }

        private bool CollideWhenRotate(bool isRotateRight)
        {
            ResetArea();
            bool isCollide = false;
            Shape shape = new Shape(currentShape);
            if (isRotateRight)
                shape.rotateRight();
            else
                shape.rotateLeft();
            for (int i = shape.y + shape.sizeMatrix - 1; i >= shape.y; --i)
            {
                for (int j = shape.x; j < shape.x + shape.sizeMatrix; ++j)
                {
                    if (shape.matrix[i - shape.y, j - shape.x] != 0)
                    {
                        if (map[i, j] != 0)
                        {
                            isCollide = true;
                            break;
                        }
                    }
                }
                if (isCollide)
                    break;
            }
            pbScene.Invalidate();
            return isCollide;
        }

        public bool CollideHorizontral(bool isMoveRight)
        {
            for (int i = currentShape.y; i < currentShape.y + currentShape.sizeMatrix; ++i)
            {
                for (int j = currentShape.x; j < currentShape.x + currentShape.sizeMatrix; ++j)
                {
                    if (currentShape.matrix[i - currentShape.y, j - currentShape.x] != 0)
                    {
                        if (isMoveRight)
                        {
                            if (j + 1 < mapWidth && map[i, j + 1] != 0)
                                return true;
                        }
                        else
                        {
                            if (j - 1 >= 0 && map[i, j - 1] != 0)
                                return true;
                        }
                    }
                }
            }
            return false;
        }

        private void ResetArea()
        {
            for (int j = currentShape.y; j < currentShape.y + currentShape.sizeMatrix; ++j)
            {
                for (int i = currentShape.x; i < currentShape.x + currentShape.sizeMatrix; ++i)
                {
                    if (currentShape.matrix[j - currentShape.y, i - currentShape.x] != 0)
                        map[j, i] = 0;
                }
            }
        }
        private void DrawMap(Graphics g)
        {
            for (int i = 0; i < mapHeight; ++i)
            {
                for (int j = 0; j < mapWidth; ++j)
                {
                    if (map[i, j] != 0)
                    {
                        if(netMode)
                            g.FillRectangle(getBrush(map[i, j]), 
                                new Rectangle(j * sizeSquareInMap + 1, i * sizeSquareInMap + 1,
                                 sizeSquareInMap - 1, sizeSquareInMap - 1));
                        else
                            g.FillRectangle(getBrush(map[i, j]),
                                new Rectangle(j * sizeSquareInMap, i * sizeSquareInMap,
                                sizeSquareInMap, sizeSquareInMap));
                    }
                }
            }
        }

        private void DrawGrid(Graphics g)
        {
            if (netMode)
            {
                for (int i = 0; i < mapHeight; ++i)
                    g.DrawLine(Pens.Black,
                        new Point(0, sizeSquareInMap * i),
                        new Point(sizeSquareInMap * mapWidth, sizeSquareInMap * i));

                for (int i = 0; i < mapWidth; ++i)
                    g.DrawLine(Pens.Black,
                        new Point(sizeSquareInMap * i, 0),
                        new Point(sizeSquareInMap * i, sizeSquareInMap * mapHeight));

                g.DrawLine(Pens.Black, new Point(0, sizeSquareInMap * mapHeight),
                    new Point(sizeSquareInMap * mapWidth, sizeSquareInMap * mapHeight));
                g.DrawLine(Pens.Black, new Point(sizeSquareInMap * mapWidth, 0),
                        new Point(sizeSquareInMap * mapWidth, sizeSquareInMap * mapHeight));

            }
            else
            {
                g.DrawLine(Pens.Black,new Point(0, 0),new Point(sizeSquareInMap * mapWidth, 0));
                g.DrawLine(Pens.Black, new Point(0, sizeSquareInMap * mapHeight),
                    new Point(sizeSquareInMap * mapWidth, sizeSquareInMap * mapHeight));
                g.DrawLine(Pens.Black,new Point(0, 0),
                        new Point(0, sizeSquareInMap * mapHeight));
                g.DrawLine(Pens.Black,new Point(sizeSquareInMap * mapWidth, 0),
                        new Point(sizeSquareInMap * mapWidth, sizeSquareInMap * mapHeight));
            }
        }
        private void DrawNextShape()
        {
            Graphics g = pbNextShape.CreateGraphics();
            int imgSize = pbNextShape.Height;
            g.FillRectangle(Brushes.Black, 0, 0, imgSize, imgSize); // make border
            g.FillRectangle(Brushes.Goldenrod, 1, 1, imgSize - 2, imgSize - 2);

            int paddingOfBlock = 20;


            int xy_0 = paddingOfBlock;
            int xy_end = imgSize - paddingOfBlock;
            double delta = (xy_end - xy_0 - nextShape.sizeMatrix) / (double)nextShape.sizeMatrix;

            g.FillRectangle(new SolidBrush(Color.White), xy_0, xy_0, xy_end - xy_0, xy_end - xy_0); // clear space for block

            double blockY0 = xy_0;
            for (int blockCoordY = 0; blockCoordY < nextShape.sizeMatrix; ++blockCoordY)
            {
                double blockX0 = xy_0;
                for (int blockCoordX = 0; blockCoordX < nextShape.sizeMatrix; ++blockCoordX)
                {
                    if (nextShape.matrix[blockCoordY, blockCoordX] != 0)
                    {
                        g.FillRectangle(getBrush(nextShape.brushIndex), (int)blockX0 + 1, (int)blockY0 + 1, 
                            (int)delta, (int)delta);
                    }
                    blockX0 += delta + 1;
                }
                blockY0 += delta + 1;
            }

            double linePosition = xy_0;

            for (int i = 0; i < nextShape.sizeMatrix; ++i)
            {
                g.DrawLine(Pens.Black, xy_0, (int)linePosition, xy_end - 1, (int)linePosition);
                g.DrawLine(Pens.Black, (int)linePosition, xy_0, (int)linePosition, xy_end - 1);
                linePosition += delta + 1;
            }
            g.DrawLine(Pens.Black, xy_0, xy_end - 1, xy_end - 1, xy_end - 1);
            g.DrawLine(Pens.Black, xy_end - 1, xy_0, xy_end - 1, xy_end - 1);

        }
        private void OnPaintMap(object sender, PaintEventArgs e)
        {
            DrawMap(e.Graphics);
            DrawGrid(e.Graphics);
        }
        private void inTheEndOfGame()
        {
            backgroundPlayer.controls.stop();
            effectsPlayer.controls.stop();
            timer1.Stop();
            this.Hide();
            TheEndOfGameForm teog =  new TheEndOfGameForm(gameMode, DateTime.Now.Ticks - startTime.Ticks,
                score, linesRemoved, blocksRemoved, levelNumber, user_id, effectVolume, level.getNumberOfLevel().ToString(),pmf);
            teog.Show();
            teog.Location = new Point(this.Location.X, this.Location.Y);
            this.Dispose();
        }

        private void btnEndGame_Click(object sender, EventArgs e)
        {
            inTheEndOfGame();
        }

        private void MainGameForm_FormClosing(object sender, FormClosingEventArgs e)
        {
            Application.Exit();
        }
       
        private void MainGameForm_ResizeEnd(object sender, EventArgs e)
        {
            panelWithScene.Size = new Size(panelWithScene.Size.Width + this.Size.Width - lastResizedWidth,
                                            panelWithScene.Size.Height + this.Size.Height - lastResizedHeight);
            pbScene.Size = new Size(pbScene.Size.Width + this.Size.Width - lastResizedWidth,
                                            pbScene.Size.Height + this.Size.Height - lastResizedHeight);
            setSizeSquareInMap();

            lastResizedHeight = this.Size.Height;
            lastResizedWidth = this.Size.Width;

            DrawNextShape();
        }

        private void btn_question_Click(object sender, EventArgs e)
        {
            long tick = DateTime.Now.Ticks;
            timer1.Stop();
            backgroundPlayer.controls.pause();
            new HelpMainGameForm().ShowDialog();

            startTime = startTime.AddTicks(DateTime.Now.Ticks - tick);
            backgroundPlayer.controls.play();
            timer1.Start();
        }

        private void btn_inquiry_Click(object sender, EventArgs e)
        {
            long tick = DateTime.Now.Ticks;
            timer1.Stop();
            backgroundPlayer.controls.pause();
            new AboutDevelopersForm().ShowDialog();

            startTime = startTime.AddTicks(DateTime.Now.Ticks - tick);
            backgroundPlayer.controls.play();
            timer1.Start();
        }
    }
}
