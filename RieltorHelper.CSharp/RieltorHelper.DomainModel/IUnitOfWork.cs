using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace RieltorHelper.DomainModel
{
    public interface IUnitOfWork: IDisposable
    {
        RieltorDbContext dbContext { get; }
        void Save();
    }
}
