using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Tetris2.Forms.Admin.Editors.GlassEditor
{
    public class Glass
    {
        private int height;
        private int width;
        private bool inGame;

        public Glass(int Width, int Height,bool InGame = false)
        {
            height = Height;
            width = Width;
            inGame = InGame;
        }
        public bool checkInGame()
        {
            return inGame;
        }
        public void setInGame(bool InGame)
        {
            inGame = InGame;
        }

        public void setHeight(int Height)
        {
            height = Height;
        }

        public int getHeight()
        {
            return height;
        }

        public void setWidth(int Width)
        {
            width = Width;
        }

        public int getWidth()
        {
            return width;
        }

        
    }
}
