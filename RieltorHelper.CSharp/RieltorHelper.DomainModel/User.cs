using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using RieltorHelper.Infrastructure;

namespace RieltorHelper.DomainModel
{
    public class User: IUser
    {
        public int Id { get; set; }
        public int Phone { get; set; }
        public string FIO { get; set; }
        public string About { get; set; }
    }
}
