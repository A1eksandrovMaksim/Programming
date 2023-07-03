using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Tetris2.Forms.Admin.Editors.BlockEditor;

namespace Tetris2.Classes
{
    class Shape
    {
        public int x;
        public int y;
        public int[,] matrix;
        public int sizeMatrix;
        public int glassHeight;
        public int glassWidth;
        public int brushIndex;

        public Shape(int _x, int _y, int _glassHeight, int _glassWidth, int _brushIndex, Block block)
        {
            glassHeight = _glassHeight;
            glassWidth = _glassWidth;
            sizeMatrix = block.getMatrixSize();
            matrix = block.parceStateToIntArrey(_brushIndex);
            brushIndex = _brushIndex;

            int emptyUpRows = 0;
            bool isFound = false;
            for (int j = 0; j < sizeMatrix; ++j)
            {
                for (int i = 0; i < sizeMatrix; ++i)
                    if (matrix[j, i] == brushIndex)
                    {
                        isFound = true;
                        break;
                    }
                if (isFound)
                    break;
                else
                    ++emptyUpRows;
            }
            x = _x;
            y = _y - emptyUpRows;
        }
        public Shape(Shape shape)
        {
            x = shape.x;
            y = shape.y;
            sizeMatrix = shape.sizeMatrix;
            matrix = new int[sizeMatrix, sizeMatrix];
            for (int i = 0; i < sizeMatrix; ++i)
                for (int j = 0; j < sizeMatrix; ++j)
                    matrix[i, j] = shape.matrix[i, j];
            glassHeight = shape.glassHeight;
            glassWidth = shape.glassWidth;
        }

        public int getQuantityNodes()
        {
            int q = 0;
            for(int i = 0; i < sizeMatrix; ++i)
            {
                for(int j = 0; j < sizeMatrix; ++j)
                {
                    if (matrix[i, j] != 0)
                        ++q;
                }
            }
            return q;
        }
        public void moveDown()
        {
            int emptyBottomRows = 0;
            bool isFound = false;
            for (int j = sizeMatrix - 1; j >= 0; --j)
            {
                for (int i = 0; i < sizeMatrix; ++i)
                    if (matrix[j, i] == brushIndex)
                    {
                        isFound = true;
                        break;
                    }
                if (isFound)
                    break;
                else
                    ++emptyBottomRows;
            }
            if (y < glassHeight - sizeMatrix + emptyBottomRows)
                ++y;
        }
        public void moveRight()
        {
            int emptyColumns = 0;
            bool isFound = false;
            for (int i = sizeMatrix - 1; i >= 0; --i)
            {
                for (int j = 0; j < sizeMatrix; ++j)
                    if (matrix[j, i] == brushIndex)
                    {
                        isFound = true;
                        break;
                    }
                if (isFound)
                    break;
                else
                    ++emptyColumns;
            }
            if (x < glassWidth - sizeMatrix + emptyColumns)
                ++x;
        }
        public void moveLeft()
        {
            int emptyColumns = 0;
            bool isFound = false;
            for (int i = 0; i < sizeMatrix; ++i)
            {
                for (int j = 0; j < sizeMatrix; ++j)
                    if (matrix[j, i] == brushIndex)
                    {
                        isFound = true;
                        break;
                    }
                if (isFound)
                    break;
                else
                    ++emptyColumns;
            }

            if (x > 0 - emptyColumns)
                --x;
        }
        public void rotateRight()
        {
            int[,] newArr = new int[sizeMatrix, sizeMatrix];
            for(int i = 0; i < sizeMatrix; ++i)
            {
                for(int j = 0; j < sizeMatrix; ++j)
                {
                    newArr[i, j] = matrix[sizeMatrix - 1 - j, i];
                }
            }
            matrix = newArr;
            correctOutOfBounds();
        }
        public void rotateLeft()
        {
            int[,] newArr = new int[sizeMatrix, sizeMatrix];
            for (int i = 0; i < sizeMatrix; ++i)
            {
                for (int j = 0; j < sizeMatrix; ++j)
                {
                    newArr[i, j] = matrix[j, sizeMatrix - 1 -i];
                }
            }
            matrix = newArr;
            correctOutOfBounds();
        }

        private void correctOutOfBounds()
        {

            int quantityLinesOutboundInRight = 0;
            int quantityLinesOutboundInLeft = 0;
            int quantityLinesOutboundInBottom = 0;
            for (int i = x + sizeMatrix - 1; i >= x; --i)
            {
                for (int j = y; j < y + sizeMatrix; ++j)
                {
                    if (matrix[j - y, i - x] != 0)
                    {
                        if (i >= glassWidth)
                            quantityLinesOutboundInRight++;
                        if (i < 0)
                            quantityLinesOutboundInLeft++;
                        if (j >= glassHeight)
                            quantityLinesOutboundInBottom++;
                    }
                }
            }
            y -= quantityLinesOutboundInBottom;
            x += quantityLinesOutboundInLeft;
            x -= quantityLinesOutboundInRight;
        }
    }
}
