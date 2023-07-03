using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Tetris2.Forms.Admin.Editors.BlockEditor
{
    public class Block
    {
        private uint state;
        private bool inGame;

        public Block(uint newState, bool newInGame = false)
        {
            this.state = newState;
            inGame = newInGame;
        }

        public Block(Block _block)
        {
            state = _block.getState();
            inGame = _block.checkInGame();
        }
        public bool checkInGame()
        {
            return inGame;
        }
        public void setState(uint newState)
        {
            state = newState;
        }
        public void setInGame(bool stateInGame)
        {
            inGame = stateInGame;
        }
        public uint getState()
        {
            return state;
        }

        public void changeState(int x, int y)
        {
            uint changeNodeInState = 1;
            changeNodeInState <<= ((y - 1)*4);
            changeNodeInState <<= (x - 1);

            if ((state & changeNodeInState) == 0)
                state += changeNodeInState;
            else
                state -= changeNodeInState;
        }

        public bool checkState(int x , int y)
        {
            uint changeNodeInState = 1;
            changeNodeInState <<= ((y - 1) * 4);
            changeNodeInState <<= (x - 1);

            if ((state & changeNodeInState) == 0)
                return false;
            else
                return true;
        }

        public bool isCorrect()
        {
            if (state == 0) return false;

            uint carrentNode = 1;
            for(; carrentNode < 0xffff; carrentNode *= 2)
                if ((carrentNode & state) != 0)
                    break;

            uint fullBlock = checkFullBlock(carrentNode, carrentNode);

            if ((~fullBlock & state) != 0)
                return false;
            else
                return true;
        }

        public void turnRight()
        {
            uint newState = 0;
            if ((state & 0x0001) != 0)
                newState += 0x0008;
            if ((state & 0x0002) != 0)
                newState += 0x0080;
            if ((state & 0x0004) != 0)
                newState += 0x0800;
            if ((state & 0x0008) != 0)
                newState += 0x8000;

            if ((state & 0x0010) != 0)
                newState += 0x0004;
            if ((state & 0x0020) != 0)
                newState += 0x0040;
            if ((state & 0x0040) != 0)
                newState += 0x0400;
            if ((state & 0x0080) != 0)
                newState += 0x4000;

            if ((state & 0x0100) != 0)
                newState += 0x0002;
            if ((state & 0x0200) != 0)
                newState += 0x0020;
            if ((state & 0x0400) != 0)
                newState += 0x0200;
            if ((state & 0x0800) != 0)
                newState += 0x2000;

            if ((state & 0x1000) != 0)
                newState += 0x0001;
            if ((state & 0x2000) != 0)
                newState += 0x0010;
            if ((state & 0x4000) != 0)
                newState += 0x0100;
            if ((state & 0x8000) != 0)
                newState += 0x1000;
            state = newState;
        }
        public void turnLeft()
        {
            uint newState = 0;
            if ((state & 0x0008) != 0)
                newState += 0x0001;
            if ((state & 0x0080) != 0)
                newState += 0x0002;
            if ((state & 0x0800) != 0)
                newState += 0x0004;
            if ((state & 0x8000) != 0)
                newState += 0x0008;

            if ((state & 0x0004) != 0)
                newState += 0x0010;
            if ((state & 0x0040) != 0)
                newState += 0x0020;
            if ((state & 0x0400) != 0)
                newState += 0x0040;
            if ((state & 0x4000) != 0)
                newState += 0x0080;

            if ((state & 0x0002) != 0)
                newState += 0x0100;
            if ((state & 0x0020) != 0)
                newState += 0x0200;
            if ((state & 0x0200) != 0)
                newState += 0x0400;
            if ((state & 0x2000) != 0)
                newState += 0x0800;

            if ((state & 0x0001) != 0)
                newState += 0x1000;
            if ((state & 0x0010) != 0)
                newState += 0x2000;
            if ((state & 0x0100) != 0)
                newState += 0x4000;
            if ((state & 0x1000) != 0)
                newState += 0x8000;
            state = newState;
        }

        public void shiftUp()
        {
            uint newState = 0;
            int shiftValue = 0;
            bool isBlock = false;
            for (uint j = 1; j <= 0x1000; j *= 16)
                {
                for (uint i = 1; i <= 8; i *= 2)
                {
                    uint node = j * i;
                    if ((node & state) != 0)
                    {
                        isBlock = true;
                        break;
                    }
                }
                if (isBlock)
                    break;
                shiftValue++;
            }
            if (!isBlock) return;

            newState = state >> (4 * shiftValue);
            state = newState;
        }
        public void shiftLeft()
        {
            uint newState = 0;
            int shiftValue = 0;
            bool isBlock = false;
            for (uint i = 1; i <= 8; i *= 2)
            {
                for (uint j = 1; j <= 0x1000; j *= 16)
                {
                    uint node = j * i;
                    if((node & state) != 0)
                    {
                        isBlock = true;
                        break;
                    }
                }
                if (isBlock)
                    break;
                shiftValue++;
            }
            if (!isBlock) return;

            newState += ((state & 0x000f) >> shiftValue) & 0x000f;
            newState += ((state & 0x00f0) >> shiftValue) & 0x00f0;
            newState += ((state & 0x0f00) >> shiftValue) & 0x0f00;
            newState += ((state & 0xf000) >> shiftValue) & 0xf000;
            state = newState;
        }

        private uint checkFullBlock(uint checkedBlocks, uint carrentNode)
        {
            switch (carrentNode)
            {
                case 0x0001:
                    {
                        checkedBlocks = checkNode_InCase_checkFullBlock(checkedBlocks, 0x0002);
                        checkedBlocks = checkNode_InCase_checkFullBlock(checkedBlocks, 0x0010);
                        break;
                    }
                case 0x0002:
                    {
                        checkedBlocks = checkNode_InCase_checkFullBlock(checkedBlocks, 0x0001);
                        checkedBlocks = checkNode_InCase_checkFullBlock(checkedBlocks, 0x0004);
                        checkedBlocks = checkNode_InCase_checkFullBlock(checkedBlocks, 0x0020);
                        break;
                    }
                case 0x0004:
                    {
                        checkedBlocks = checkNode_InCase_checkFullBlock(checkedBlocks, 0x0008);
                        checkedBlocks = checkNode_InCase_checkFullBlock(checkedBlocks, 0x0002);
                        checkedBlocks = checkNode_InCase_checkFullBlock(checkedBlocks, 0x0040);
                        break;
                    }
                case 0x0008:
                    {
                        checkedBlocks = checkNode_InCase_checkFullBlock(checkedBlocks, 0x0004);
                        checkedBlocks = checkNode_InCase_checkFullBlock(checkedBlocks, 0x0080);
                        break;
                    }
                case 0x0010:
                    {
                        checkedBlocks = checkNode_InCase_checkFullBlock(checkedBlocks, 0x0001);
                        checkedBlocks = checkNode_InCase_checkFullBlock(checkedBlocks, 0x0100);
                        checkedBlocks = checkNode_InCase_checkFullBlock(checkedBlocks, 0x0020);
                        break;
                    }
                case 0x0020:
                    {
                        checkedBlocks = checkNode_InCase_checkFullBlock(checkedBlocks, 0x0002);
                        checkedBlocks = checkNode_InCase_checkFullBlock(checkedBlocks, 0x0200);
                        checkedBlocks = checkNode_InCase_checkFullBlock(checkedBlocks, 0x0010);
                        checkedBlocks = checkNode_InCase_checkFullBlock(checkedBlocks, 0x0040);
                        break;
                    }
                case 0x0040:
                    {
                        checkedBlocks = checkNode_InCase_checkFullBlock(checkedBlocks, 0x0400);
                        checkedBlocks = checkNode_InCase_checkFullBlock(checkedBlocks, 0x0004);
                        checkedBlocks = checkNode_InCase_checkFullBlock(checkedBlocks, 0x0020);
                        checkedBlocks = checkNode_InCase_checkFullBlock(checkedBlocks, 0x0080);
                        break;
                    }
                case 0x0080:
                    {
                        checkedBlocks = checkNode_InCase_checkFullBlock(checkedBlocks, 0x0800);
                        checkedBlocks = checkNode_InCase_checkFullBlock(checkedBlocks, 0x0008);
                        checkedBlocks = checkNode_InCase_checkFullBlock(checkedBlocks, 0x0040);
                        break;
                    }
                case 0x0100:
                    {
                        checkedBlocks = checkNode_InCase_checkFullBlock(checkedBlocks, 0x1000);
                        checkedBlocks = checkNode_InCase_checkFullBlock(checkedBlocks, 0x0010);
                        checkedBlocks = checkNode_InCase_checkFullBlock(checkedBlocks, 0x0200);
                        break;
                    }
                case 0x0200:
                    {
                        checkedBlocks = checkNode_InCase_checkFullBlock(checkedBlocks, 0x2000);
                        checkedBlocks = checkNode_InCase_checkFullBlock(checkedBlocks, 0x0020);
                        checkedBlocks = checkNode_InCase_checkFullBlock(checkedBlocks, 0x0100);
                        checkedBlocks = checkNode_InCase_checkFullBlock(checkedBlocks, 0x0400);
                        break;
                    }
                case 0x0400:
                    {
                        checkedBlocks = checkNode_InCase_checkFullBlock(checkedBlocks, 0x4000);
                        checkedBlocks = checkNode_InCase_checkFullBlock(checkedBlocks, 0x0040);
                        checkedBlocks = checkNode_InCase_checkFullBlock(checkedBlocks, 0x0800);
                        checkedBlocks = checkNode_InCase_checkFullBlock(checkedBlocks, 0x0200);
                        break;
                    }
                case 0x0800:
                    {
                        checkedBlocks = checkNode_InCase_checkFullBlock(checkedBlocks, 0x8000);
                        checkedBlocks = checkNode_InCase_checkFullBlock(checkedBlocks, 0x0080);
                        checkedBlocks = checkNode_InCase_checkFullBlock(checkedBlocks, 0x0400);
                        break;
                    }
                case 0x1000:
                    {
                        checkedBlocks = checkNode_InCase_checkFullBlock(checkedBlocks, 0x0100);
                        checkedBlocks = checkNode_InCase_checkFullBlock(checkedBlocks, 0x2000);
                        break;
                    }
                case 0x2000:
                    {
                        checkedBlocks = checkNode_InCase_checkFullBlock(checkedBlocks, 0x0200);
                        checkedBlocks = checkNode_InCase_checkFullBlock(checkedBlocks, 0x1000);
                        checkedBlocks = checkNode_InCase_checkFullBlock(checkedBlocks, 0x4000);
                        break;
                    }
                case 0x4000:
                    {
                        checkedBlocks = checkNode_InCase_checkFullBlock(checkedBlocks, 0x0400);
                        checkedBlocks = checkNode_InCase_checkFullBlock(checkedBlocks, 0x2000);
                        checkedBlocks = checkNode_InCase_checkFullBlock(checkedBlocks, 0x8000);
                        break;
                    }
                case 0x8000:
                    {
                        checkedBlocks = checkNode_InCase_checkFullBlock(checkedBlocks, 0x0800);
                        checkedBlocks = checkNode_InCase_checkFullBlock(checkedBlocks, 0x4000);
                        break;
                    }
            }
            return checkedBlocks;
        }
        private uint checkNode_InCase_checkFullBlock(uint checkedBlocks, uint nodeForCheck)
        {
            if ((state & nodeForCheck) != 0)
            {
                if ((checkedBlocks & nodeForCheck) == 0)
                {
                    checkedBlocks += nodeForCheck;
                    checkedBlocks = checkFullBlock(checkedBlocks, nodeForCheck);
                }
            }
            return checkedBlocks;
        }
        public int getMatrixSize()
        {
            int widthSize = getBlockWidth();
            int heightSize = getBlockHeight();
            return widthSize > heightSize ? widthSize : heightSize;
        }

        public int getBlockHeight()
        {
            int heightSize = 4;
            bool isEmptyLine = true;
            for (int i = 0x1000; i > 0; i >>= 4)
            {
                for (int j = 1; j < 9; j *= 2)
                {
                    if ((state & (i * j)) != 0)
                    {
                        isEmptyLine = false;
                        break;
                    }
                }
                if (!isEmptyLine)
                    break;
                else
                    --heightSize;
            }
            return heightSize;
        }

        public int getBlockWidth()
        {
            int widthSize = 4;
            bool isEmptyLine = true;
            for (int j = 8; j > 0; j /= 2)
            {
                for (int i = 0x1000; i > 0; i >>= 4)
                {
                    if ((state & (i * j)) != 0)
                    {
                        isEmptyLine = false;
                        break;
                    }
                }
                if (!isEmptyLine)
                    break;
                else
                    --widthSize;
            }
            return widthSize;
        }
        public int[,] parceStateToIntArrey(int brushIndex)
        {
            int matrixSize = getMatrixSize();
            int[,] arr = new int[matrixSize, matrixSize];
            for(int i = 0, y = 0x0001; i < matrixSize; ++i, y<<=4)
            {
                for(int j = 0, x = 1; j < matrixSize; ++j, x*=2)
                {
                    arr[i, j] = (state & (x * y)) != 0 ? brushIndex : 0;
                }
            }
            return arr;
        }
    }
}
