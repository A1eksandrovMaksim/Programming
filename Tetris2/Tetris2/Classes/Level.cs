using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Tetris2.Classes;
using Tetris2.Forms.Admin.Editors.BlockEditor;
using Tetris2.Forms.Admin.Editors.GlassEditor;

namespace Tetris2.Classes
{
    public class Level
    {
        private string discription;
        private int numberOfLevel;
        private double fallingSpeed;
        private bool enableNetMode;
        private int pointsForLine;
        private List<Block> blocks;
        private List<Glass> glasses;
        private List<Sublevel> sublevels;

        public Level(string Discription,
                     int NumberOfLevel,
                     double FallingSpeed,
                     bool EnableNetMode,
                     int PointsForLine,
                     List<Block> Blocks,
                     List<Glass> Glasses, 
                     List<Sublevel> Sublevels)
        {
            discription = Discription;
            numberOfLevel = NumberOfLevel;
            fallingSpeed = FallingSpeed;
            enableNetMode = EnableNetMode;
            pointsForLine = PointsForLine;
            blocks = Blocks;
            glasses = Glasses;
            sublevels = Sublevels;
        }

        public Level()
        {
            discription = "";
            numberOfLevel = 1;
            fallingSpeed = 0.25;
            enableNetMode = true;
            pointsForLine = 0;
            blocks = new List<Block>();
            glasses = new List<Glass>();
            sublevels = new List<Sublevel>();
        }

        public string getDiscription() 
        { 
            return discription; 
        }
        public void setDiscription(string Discription)
        {
            discription = Discription;
        }

        public int getNumberOfLevel()
        {
            return numberOfLevel;
        }
        public void setnumberOfLevel(int NumberOfLevel)
        {
            numberOfLevel = NumberOfLevel;
        }

        public double getFallingSpeed()
        {
            return fallingSpeed;
        }
        public void setfallingSpeed(double FallingSpeed)
        {
            fallingSpeed = FallingSpeed;
        }

        public bool getEnableNetMode()
        {
            return enableNetMode;
        }
        public void setEnableNetMode(bool EnableNetMode)
        {
            enableNetMode = EnableNetMode;
        }

        public int getpointsForLine()
        {
            return pointsForLine;
        }
        public void setpointsForLine(int PointsForLine)
        {
            pointsForLine = PointsForLine;
        }

        public List<Block> getBlocks()
        {
            return blocks;
        }
        public void setBlocks(List<Block> Blocks)
        {
            blocks = Blocks;
        }

        public List<Glass> getGlasses()
        {
            return glasses;
        }
        public void setBlocks(List<Glass> Glasses)
        {
            glasses = Glasses;
        }

        public List<Sublevel> getSublevels()
        {
            return sublevels;
        }
        public void setSublevels(List<Sublevel> sls)
        {
            sublevels = sls;
        }

    }
}
