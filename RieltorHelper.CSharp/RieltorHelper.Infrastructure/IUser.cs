using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Runtime.Serialization;

namespace RieltorHelper.Infrastructure
{
    public interface IUser
    {
        int Id { get; set; }
        int Phone { get; set; }
        string FIO { get; set; }
        string About { get; set; }
    }
}
