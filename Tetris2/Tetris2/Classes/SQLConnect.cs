using Npgsql;
using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Tetris2.Classes
{
    public class SQLConnect
    {
        private string connString = "Host=localhost;Username=postgres;Port=5432;Password=Password;Database=dbtetris";
        private NpgsqlConnection nConn;
        private NpgsqlCommand nCmd;
        public SQLConnect() { }
        private void connect()
        {
            nConn = new NpgsqlConnection(connString);
            if (nConn.State == ConnectionState.Closed)
            {
                nConn.Open();
            }
        }

        public DataTable getData(string sql)
        {
            connect();
            DataTable dt = new DataTable();
            nCmd = new NpgsqlCommand(sql, nConn);
            NpgsqlDataReader ndr = nCmd.ExecuteReader();
            dt.Load(ndr);
            nConn.Close();
            return dt;
        }
        public void setData(string sql)
        {
            connect();
            nCmd = new NpgsqlCommand(sql, nConn);
            NpgsqlDataReader ndr = nCmd.ExecuteReader();
            nConn.Close();
        }
    }
}
