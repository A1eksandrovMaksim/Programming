using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Tetris2.Classes
{
    public class UserClass
    {
        private int user_id;
        private string login;
        private string password;
        public UserClass(int _user_id, string _login, string _password)
        {
            user_id = _user_id;
            login = _login;
            password = _password;
        }
        public void setLogin(string _login)
        {
            login = _login;
        }
        public string getLogin()
        {
            return login;
        }

        public void setPassword(string _password)
        {
            password = _password;
        }
        public string getPassword()
        {
            return password;
        }
        public int getUserID()
        {
            return user_id;
        }
    }
}
