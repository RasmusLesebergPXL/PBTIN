   M S B A M L   `   `   `  ����D  @PixelPass, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null%clr-namespace:PixelPass	PixelPass  5   	       PixelPass.MainWindow   5   	   W SPresentationCore, Version=6.0.2.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35\ XPresentationFramework, Version=6.0.2.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35e aSystem.Windows.Controls.Ribbon, Version=6.0.2.0, Culture=neutral, PublicKeyToken=b77a5c561934e089R NWindowsBase, Version=6.0.2.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35F 9http://schemas.microsoft.com/winfx/2006/xaml/presentation     5   	   R NSystem.Xaml, Version=6.0.2.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5   	   @d2http://schemas.microsoft.com/expression/blend/2008     5   	   Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5   	   )localclr-namespace:PixelPass     5   	   $	��305��5   	   $	��643��6   
������  � Title$'  !PixelPass - Your password manager��5	   !   .��5
      ]� .+�5   
   o� $	��Top=�6   .@�5      m� $
��File��6   .@�5      m� -   5        $��openItem��5   *   $��_Open��6   6:   m� 5      -   5        $��saveItem��5   *   $��_Save��6   ${�False��6:   �� 5      m� 5      -   5        $��exitItem��5   *   $��E_xit��6   6*   5      5      � 5   
   $��Bottom=�6   .+�5      �� $
��Left=�6   $��	38,18,0,0q�63   $��	Accounts:��6F   $	��Top=�6W   �� 5      -   5        $��accountInfoListBox��5      $
��Left=�5      $	��157��61   $��	38,39,0,0q�6>   $	��Top=�5      $	��170��6/   5      �� 5      -   5        $��newAccountInfoButton��5      $
��Left=�5      ${�False��60   $��178,201,0,0q�5      $	��Top=�6*   $��30��5      $��30��6    $��24(�5      $��0q�6#   $��Center=�5      $��Center=�69   .��5       �� $��+��6   $��0,-7,0,0q�6%   5!      �� 5"      -   5        $��detailsCanvas��5%      $
��Left=�5"      $	��158��60   $��
254,38,0,0q�6=   $	��Top=�5#      $	��350��6-   
�������5&      �� 5(      $
��Left=�6   $��
261,40,0,0q�63   $��Title:��6G   $	��Top=�6U   �� 5)      $
��Left=�6   $��
261,75,0,0q�63   $��	Username:��6G   $	��Top=�6X   �� 5*      $
��Left=�6   $��261,110,0,0q�63   $��	Password:��6H   $	��Top=�6Y   �� 5+      $
��Left=�6   $��261,145,0,0q�63   $��Notes:��6H   $	��Top=�6V   �� 5,      $
��Left=�6   $��261,180,0,0q�63   $��Expiration date:��6H   $	��Top=�6`   �� 5.      -   5        $��titleTextBlock��5/      $
��Left=�5.      $��
370,40,0,0q�63   $	��Top=�5/   .   $��(Title)��6F   �� 50      -   5        $��usernameTextBlock��51      $
��Left=�50      $��
370,75,0,0q�63   $	��Top=�51   1   $��
(username)��6I   �� 53      -	   5        $��
copyButton��54   8   $
��Copy��53      $
��Left=�6$   $��370,106,0,0q�6?   $	��Top=�54      $��75��6-   ${�False��55      6'   �� 57      -
   5        $��notesTextBlock��58      $
��Left=�57      $��370,145,0,0q�63   $	��Top=�58   .   $��(notes)��6F   $	��184��6U   $��34��6a   $
��Wrap=�59      �� 5:      -   5        $��expirationTextBlock��5;      $
��Left=�5:      $��370,180,0,0q�63   $	��Top=�5;   3   $��(expiration)��6K   � 5<      -   5        $��expirationProgressBar��5>      $
��Left=�5<      $��10��65   $��454,116,0,0q�6A   $	��Top=�5=      $	��100��62    � Maximum$ 5Q�5>   7   5?      5@      5A      