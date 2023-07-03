using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Tetris2.Classes
{
    public class Sublevel
    {
        private int sublevel_id;
        private long limitPoints;
        public Sublevel(long _limitPoints, int _sublevel_id)
        {
            limitPoints = _limitPoints;
            sublevel_id = _sublevel_id;
        }
        public long getLimitPoints()
        {
            return limitPoints;
        }
        public void setLimitPoints(long _limitPoints)
        {
            limitPoints = _limitPoints;
        }
        public void setSublevelId(int id)
        {
            sublevel_id = id;
        }
        public int getSublevelId()
        {
            return sublevel_id;
        }
    }
}
