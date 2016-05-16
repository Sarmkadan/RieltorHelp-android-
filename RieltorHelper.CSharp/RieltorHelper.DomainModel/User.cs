using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using RieltorHelper.Infrastructure;
using System.Runtime.Serialization;

namespace RieltorHelper.DomainModel
{
    [DataContract]
    public class User : IUser
    {
        [DataMember]
        public int Id { get; set; }
        [DataMember]
        public int Phone { get; set; }
        [DataMember]
        public string FIO { get; set; }
        [DataMember]
        public string About { get; set; }
    }
}
