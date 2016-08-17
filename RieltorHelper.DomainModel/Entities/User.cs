using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Runtime.Serialization;
using Newtonsoft.Json;

namespace RieltorHelper.DomainModel
{
    [JsonObject]
    public class User
    {
        public int Id { get; set; }
        public string Phone { get; set; }
        public string FIO { get; set; }
        public string About { get; set; }
    }
}
