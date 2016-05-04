using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Web;
using System.Text;
using System.Data.SQLite;
using System.Xml.Schema;
using System.Xml;

namespace RealEstateApi
{
    public class Client : IClient
    {
        public XmlElement GetClients(string value)
        {
            string path = @System.Web.Hosting.HostingEnvironment.ApplicationPhysicalPath + "reiltorhelper.db";
            string output = "<clients>";

            SQLiteConnection conn = new SQLiteConnection("Data Source=" + path + ";Version=3;New=True;Compress=True;");
            SQLiteCommand cmd = conn.CreateCommand();
            conn.Open();

            cmd.CommandText = "select * from Klient where fio like '%"+value+"%'";
            SQLiteDataReader reader = cmd.ExecuteReader();

            while (reader.Read())
            {
                output += "<client><phone>" + reader["phone"] + "</phone><fio>" + reader["fio"] + "</fio><about>" + reader["about"] + "</about></client>";
            }

            output += "</clients>";

            XmlDocument doc = new XmlDocument();
            doc.LoadXml(output);
            return doc.DocumentElement;
        }
    }
}
