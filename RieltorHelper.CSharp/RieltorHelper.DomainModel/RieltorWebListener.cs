using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Net;
using RieltorHelper.Infrastructure;
using System.Threading.Tasks;
using System.Net.Sockets;

namespace RieltorHelper.DomainModel
{
    public class RieltorWebListener : IRieltorWebListener
    {
        List<TcpClient> tcpClientCollection;
        List<NetworkStream> networkStreamCollection;
        TcpListener listener;
        
        public RieltorWebListener()
        {
            tcpClientCollection = new List<TcpClient>();
            networkStreamCollection = new List<NetworkStream>();
        }

        public bool Listen(int port)
        {
            listener = new TcpListener(new IPEndPoint(IPAddress.Any, port));
            listener.Start();
            try
            {
                listener.BeginAcceptTcpClient(new AsyncCallback(ClientConnect), null);
                return true;
            }
            catch (TimeoutException )
            {
                return false;
            }
            catch
            {
                throw;
            }
        }
        
        private void ClientConnect(IAsyncResult ar)
        {
            TcpClient client = listener.EndAcceptTcpClient(ar);
            tcpClientCollection.Add(client);
            networkStreamCollection.Add(client.GetStream());
        }

        public void Stop()
        {
            for (int i = 0; i< tcpClientCollection.Count; i++)
            {
                tcpClientCollection[i].Close();
                networkStreamCollection[i].Close();
            }
            listener.Stop();
        }

        public string getDB(int websocket, string path)
        {
            throw new NotImplementedException();
        }

        public IDataTable getDataTable(string cynhDB)
        {
            throw new NotImplementedException();
        }
    }
}
