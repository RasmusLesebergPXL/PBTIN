   M S B A M L   `   `   `  ����J  FZoek_en_Vervang, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null1clr-namespace:Zoek_en_VervangZoek_en_Vervang  5   	        Zoek_en_Vervang.MainWindow   5   	   W SPresentationCore, Version=6.0.2.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35\ XPresentationFramework, Version=6.0.2.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35e aSystem.Windows.Controls.Ribbon, Version=6.0.2.0, Culture=neutral, PublicKeyToken=b77a5c561934e089R NWindowsBase, Version=6.0.2.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35F 9http://schemas.microsoft.com/winfx/2006/xaml/presentation     5   	   R NSystem.Xaml, Version=6.0.2.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5   	   @d2http://schemas.microsoft.com/expression/blend/2008     5   	   Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5   	   /localclr-namespace:Zoek_en_Vervang     5   	     � Title$  
MainWindow��5   	   $	��450��6   $	��411��6)   .��5	      � $��Center=�6   $	��411��6(   .+�5
   
   �� $��Search: ��6   $
��Left=�6#   $��32��6>   $��	44,49,0,0q�6J   $	��Top=�6]   $��85��6u   �� 5   
   $��Replace with: ��6   $
��Left=�6)   $��32��6D   $��	44,81,0,0q�6P   $	��Top=�6c   $��99��6{   �� 5   
   $��Algoritme: ��6   $
��Left=�6&   $��28��6A   $��
44,118,0,0q�6M   $	��Top=�6a   $��99��6y   �� 5   
   -   5        $��inputTextBox��5   >   $
��Left=�5      $��25��6-   $��
157,49,0,0q�69    �� TextWrapping$
 Wrap=�6M   $�� ��5      $	��Top=�6   $	��226��62   6>   �� 5   
   -   5        $��replaceTextBox��5   >   $
��Left=�5      $��25��6-   $��
157,81,0,0q�69   $
 Wrap=�6M   $�� ��5      $	��Top=�6   $	��226��62   6>   �� 5   
   -   5        $��algoritmeComboBox��5   7   $
��Left=�5      $��28��6.   $��157,118,0,0q�6:   $	��Top=�5      $	��226��6+   .@�5      �� .��6   Ask Frasier methode60   �� 5      .��6   StringBuilder methode62   �� 5      .��6   Biblotheek methode6/   5      �� 5   
   -   5        $��executeButton��5   4   $��Execute��5      $
��Left=�6#   $��23��6>   $��112,166,0,0q�6J   $	��Top=�5      $��80��6)   6I   �� 5   
   -   5        $��clearButton��5   4   $��Clear��5      $
��Left=�6!   $��23��6<   $��206,166,0,0q�6H   $	��Top=�5      $��80��6)   6G   �� 5   
   -   5        $��
loadButton��5   4   $
��Load��5      $
��Left=�6    $��23��6;   $��304,166,0,0q�6G   $	��Top=�5      $��80��6)   6F   �� 5   
   -   5        $��outputTextBox��5   >   $
��Left=�5      $	��179��6-   $��
44,204,0,0q�6:   $
 Wrap=�6N   $�� ��5      $	��Top=�6   $	��339��62   " �� VerticalScrollBarVisibility$ Visible=�5      �� 5    
   -   5        $��uitvoeringsTijdLabel��5!   4   $�� ��5       $
��Left=�6   $��25��66   $��
44,388,0,0q�6B   $	��Top=�5!      $	��202��6(   64   5#      5$      