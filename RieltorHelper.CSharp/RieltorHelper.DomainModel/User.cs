using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Runtime.Serialization;

namespace RieltorHelper.DomainModel
{
    public class User: IDatabaseEntity
    {
        public int Id { get; set; }
        public int Phone { get; set; }
        public string FIO { get; set; }
        public string About { get; set; }
    }
}
