using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations.Schema;
using System.ComponentModel.DataAnnotations;
using System.Globalization;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace RealEstateApiV3.Models
{
    [Table("Client")]
    public class ClientModel
    {
        [Key]
        [Column(Order = 1)]
        public int Id { get; set; }
        public string Name { get; set; }
        public string Address { get; set; }
        public string City { get; set; }
        public string Country { get; set; }
        public string Zip { get; set; }
        public string Email { get; set; }
        public string Phone { get; set; }
        public string Notes
        {
            get
            {
                return string.Format(CultureInfo.CurrentCulture,
               "api/client/{0}", this.Id);
            }
            set { }
        }
    }
}
