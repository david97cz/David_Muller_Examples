import tkinter as tk
import pandas as pd
import matplotlib.pyplot as plt
import os

root = tk.Tk()

class Protocol:
    def __init__(self,pocet_mereni):
        self.pocet_mereni = pocet_mereni

    def make_protocol(self):
        file = os.path.dirname(__file__)
        data_xls = [f"svar{i}.xlsx" for i in range(1, 6)]

        # incializace
        data = [[] for i in range(self.pocet_mereni)]
        dataXY = [[[]] for i in range(self.pocet_mereni)]
        offsetX = [[] for i in range(self.pocet_mereni)]

        data2 = pd.read_excel(os.path.join(file,'Data\\welds\\hlavicka.xlsx'))
        data_eval = pd.DataFrame(data2,
                                 columns=['mereni_dne', 'typ_sondy', 'sonda', 'prumer_sondy', 'frekvence', 'f_min',
                                          'f_max',
                                          'zesileni', 'svar', 'prumer_svaru', 'energie_pulzu'])
        datum = data_eval['mereni_dne'][0]
        datum = datum.strftime("%d/%m/%Y")
        text_eval = 'Ultrazvukové zkoušení bodových svarů' + \
                    '\nMěření dne: ' + datum + \
                    '\nTyp sondy: ' + str(data_eval['typ_sondy'][0]) + \
                    '\nSonda: ' + str(data_eval['sonda'][0]) + \
                    '\nPrůměr sondy: ' + str(data_eval['prumer_sondy'][0]) + ' mm' + \
                    '\nFrekvence: ' + str(data_eval['frekvence'][0]) + ' MHz' + \
                    '\nRozsah frekvencí: ' + str(data_eval['f_min'][0]) + ' - ' + str(
            data_eval['f_max'][0]) + ' MHz ' + \
                    '\nZesíleni: ' + str(data_eval['zesileni'][0]) + ' dB' + \
                    '\nSvar: ' + str(data_eval['svar'][0]) + \
                    '\nPrůměr svaru: ' + str(data_eval['prumer_svaru'][0]) + ' mm' + \
                    '\nEnergie vysílacího pulsu: ' + str(data_eval['energie_pulzu'][0]) + ' V'

        plt.subplot(3, 3, 1)
        plt.text(0.1, 0.3, text_eval)
        plt.axis('off')

        just_file = [0 for i in range(len(data_xls))]
        for i in range(len(data_xls)):
            name = data_xls

        # for cyklus pro vykresleni grafu
        for i in range(0, len(data_xls)-1):
            data[i] = pd.read_excel(os.path.join(file,'Data\\welds',data_xls[i]))

            dataXY[i] = pd.DataFrame(data[i], columns=['Time - Ascan', 'Amplitude - Ascan'])
            offsetX[i] = dataXY[i]['Time - Ascan'].__sub__(dataXY[i]['Time - Ascan'][0])

            plt.subplot(3, 2, i + 2)
            plt.plot(offsetX[i], dataXY[i]['Amplitude - Ascan'], linewidth=1,
                     label=str(i+1) + ') ' + str(name[i]))
            plt.grid(True)
            plt.legend()
        plt.show()