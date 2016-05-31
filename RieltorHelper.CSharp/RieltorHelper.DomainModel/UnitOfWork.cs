using System;
using System.Collections.Generic;
using System.Linq;

namespace RieltorHelper.DomainModel
{
    public class UnitOfWork: IUnitOfWork
    {
        RieltorDbContext _context;
        bool _disposed = false;

        public RieltorDbContext dbContext
        {
            get
            {
                if (_context == null)
                    _context = new RieltorDbContext();
                return _context;
            }
        }

        public UnitOfWork()
        {
            _context = new RieltorDbContext();
        }
        
        public void Save()
        {
            _context.SaveChanges();
        }
        
        protected virtual void Dispose(bool disposing)
        {
            if (!_disposed)
            {
                if (disposing)
                {
                    _context.Dispose();
                }
                _disposed = true;
            }
        }
    
        public void Dispose()
        {
            Dispose(true);
            GC.SuppressFinalize(this);
        }
    }
}