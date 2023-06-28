using System;
using System.Collections.Generic;

namespace BikeRent
{
    public enum Gender
    {
        Male,
        Female
    }

    public abstract class BikeBase
    {
        private List<Rental> _rentals;

        public BikeBase()
        {
            _rentals = new List<Rental>();
            LastMaintenanceDate = DateTime.MinValue;
        }
        
        public int Id { get; set; }
        public string Brand { get; set; }
        public string Type { get; set; }
        public string Description { get; set; }
        public double TotalDistance { get; set; }
        public DateTime LastMaintenanceDate { get; set; }
        public Gender Gender { get; set; }
        public double PricePerDay { get; set; }

        public abstract int KmPerMaintenanceCycle { get; }

        public bool NeedsMaintenance()
        {
            if (TotalDistance > KmPerMaintenanceCycle)
            {
                return true;
            }
            return false;
        }

        public List<Rental> Rentals
        {
            get
            {
                return _rentals;
            }
        }

        public bool IsOccupied
        {
            get
            {
                // When a bike rental is ended, its Distance will be entered
                var rental = FindCurrentRental();
                return ((rental != null) && (rental.Distance == 0));
            }
        }

        public Rental FindCurrentRental()
        {
            Rental currentRental = null;

            if ((_rentals != null) && (_rentals.Count > 0))
            {
                currentRental = _rentals[0];  //Hij pakt de eerste
            }

            return currentRental;
        }

        public void Rent(DateTime startDate, int days, string customer)
        {
            Rental rentalObject = new Rental(startDate, days, PricePerDay, customer);
            _rentals[0] = rentalObject;
        }

        public void Return(double distance)
        {
            Rental rental = FindCurrentRental();
            rental.Distance = distance;
            TotalDistance += distance;

            //ToDo: find the current rental and fill out its distance.
            //      Don't forget to update the total distance!
        }
    }
}
