using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace RieltorHelper.Infrastructure
{
    public interface IRieltorWebListener
    {
        bool Listen(int port);
        string getDB(int websocket, string path);
        IDataTable getDataTable(string cynhDB);
        void Stop();
    }
}
