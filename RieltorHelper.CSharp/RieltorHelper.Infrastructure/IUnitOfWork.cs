using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace RieltorHelper.Infrastructure
{
    public interface IUnitOfWork
    {
        IRieltorRepository<IUser> UserRepository { get; set; }
        void Save();
    }
}
