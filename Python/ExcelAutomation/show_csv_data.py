import numpy as np
import matplotlib.pyplot as plt
import pandas as pd
import os

class Csv_viewer:
    def __init__(self,l_index,h_index):
        self.l_index = l_index
        self.h_index = h_index
    def show_graph(self):
        dirname = os.path.dirname(__file__)
        file_name_aq = os.path.join(dirname,'Data\\csv\\bodovy_svar_AQLN_7.5x7-CT_gel_s1_vz1A_09_01_2024_101107.csv')
        file_name_pryz = os.path.join(dirname,'Data\\csv\\svar_ok_pryz.csv')

        #membranova
        data_aq = pd.read_csv(file_name_aq,sep = ';')
        dataX_aq = data_aq.iloc[self.l_index:self.h_index,0]-data_aq.iloc[self.l_index,0]
        dataY_aq = data_aq.iloc[self.l_index:self.h_index,1]

        #pryzova
        data_pryz = pd.read_csv(file_name_pryz,sep = ';')
        dataX_pryz = data_pryz.iloc[self.l_index:self.h_index, 0]-data_pryz.iloc[self.l_index, 0]
        dataY_pryz = data_pryz.iloc[self.l_index:self.h_index,1]

        # print(read_file_max)
        #dataXY_max = pd.DataFrame(read_file_max, columns=['vzdalenost', 'hodnota'])
        plt.subplot(2, 1, 1)
        plt.plot(dataX_aq,dataY_aq)
        plt.title('Aqualene',loc='left')
        plt.ylabel('Amplituda [%]')
        plt.grid(True)
        plt.subplot(2, 1, 2)
        plt.plot(dataX_pryz,dataY_pryz)
        plt.title('Pryžová kulička', loc='left')
        plt.xlabel('Vzdálenost [mm]')
        plt.ylabel('Amplituda [%]')
        plt.grid(True)
        plt.show()