using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using RieltorHelper.Infrastructure;

namespace RieltorHelper.DomainModel
{
    public class UsersRepository : IRieltorRepository<User>
    {
        private RieltorDbContext _context;

        public UsersRepository(RieltorDbContext context)
        {
            _context = context;
        }

        public IEnumerable<User> GetByFIO(string fio)
        {
            return _context.Users.Where(u => u.FIO.Contains(fio)).ToList();
        }

        public void Create(User value)
        {
            _context.Users.Add(value);
            _context.SaveChanges();
        }

        public void Delete(int id)
        {
            var userToDelete = _context.Users.Find(id);
            if (userToDelete != null)
            {
                _context.Users.Remove(userToDelete);
                _context.SaveChanges();
            }
        }

        public void Edit(int id, User value)
        {
            if (value.Id == id)
            {
                _context.Entry(value).State = System.Data.Entity.EntityState.Modified;
                _context.SaveChanges();
            }
        }

        public User Get(int id)
        {
            return _context.Users.Find(id);
        }

        public IEnumerable<User> GetAll(int offset, int count)
        {
            return _context.Users.Take(count);
        }

        public int GetCount()
        {
            return _context.Users.Count();
        }
    }
}
