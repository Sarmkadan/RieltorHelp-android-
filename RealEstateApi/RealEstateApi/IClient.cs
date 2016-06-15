using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Web;
using System.Text;
using System.Xml.Schema;
using System.Xml;

namespace RealEstateApi
{
    [ServiceContract]
    public interface IClient
    {
        [OperationContract]
        [WebGet]
        XmlElement GetClients(string fio);
    }
}
