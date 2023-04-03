using InternshipsAdmin.AppLogic.Contracts;
using InternshipsAdmin.Domain;
using InternshipsAdmin.Infrastructure;
using System;
using System.Collections.Generic;
using System.Windows;
using System.Windows.Controls;

namespace InternshipsAdmin.UI
{
    public partial class MainWindow : Window
    {
        private ICompanyRepository _companyRepository;
        private IStudentsRepository _studentRepository;
        public MainWindow(ICompanyRepository companyRepository, IStudentsRepository studentsRepository)
        {
            InitializeComponent();
            _companyRepository = companyRepository;
            _studentRepository = studentsRepository;
            CompanyDataGrid.ItemsSource = _companyRepository.GetAll();
            rowToHide.Height = new GridLength(0);
        }


        private void UpdateComboboxes()
        {
            StudentsComboBox.Items.Refresh();
            SupervisorsComboBox.Items.Refresh();
        }

        private void CompanyDataGrid_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            rowToHide.Height = GridLength.Auto;
            Company selectedCompany = (Company)CompanyDataGrid.SelectedItem;
            StudentDataGrid.ItemsSource = _companyRepository.GetStudentsOfCompany(selectedCompany.CompanyId);
            StudentsComboBox.ItemsSource = _studentRepository.GetStudentsWithoutSupervisor();
            SupervisorsComboBox.ItemsSource = _companyRepository.GetSupervisorsOfCompany(selectedCompany.CompanyId);
        }


        private void AddStudentForCompanyButton_Click(object sender, RoutedEventArgs e)
        {
            Student student = (Student)StudentsComboBox.SelectedItem;
            Supervisor supervisor = (Supervisor)SupervisorsComboBox.SelectedItem;

            _companyRepository.AddStudentWithSupervisorForCompany(student, supervisor);
            UpdateComboboxes();
        }

        private void RemoveStudentFromSupervisorButton_Click(object sender, RoutedEventArgs e)
        {
            Student student = (Student)StudentsComboBox.SelectedItem;
            Supervisor supervisor = (Supervisor)SupervisorsComboBox.SelectedItem;

            _companyRepository.RemoveStudentFromSupervisor(student, supervisor);
        }

    }

}


