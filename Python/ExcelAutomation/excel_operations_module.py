import pandas as pd
import numpy as np

class DataToCsv:
    def __init__(self,file):
        self.file = file

    def convert_data(self):
        complete_file = self.file.split("/")
        just_file = "/".join(complete_file[:-1])
        name = complete_file[-1].split(".")
        just_name = name[0]

        read_file = pd.read_excel (self.file)
        dataXY = pd.DataFrame(read_file, columns= ['Time - Ascan','Amplitude - Ascan'])
        dataXY.to_csv(just_file+"/"+just_name+".txt", index = None, header=True)

    def unite_max(self,name):
        complete_file = self.file.split("/")
        file = "/".join(complete_file[:-1])
        print(file)

        # incializace
        pocet_mereni = len(name)
        pocet_maxim = 7

        maxima = [[] for i in range(pocet_mereni)]
        dataXYmaxima = [[] for i in range(pocet_mereni)]
        vyhodnoceni = np.zeros((pocet_mereni, pocet_maxim))

        for i in range(0, pocet_mereni):
            maxima[i] = pd.read_csv(file +"/"+ name[i] + 'maxima.csv', delimiter=';')
            dataXYmaxima[i] = pd.DataFrame(maxima[i], columns=['vzdalenost', 'hodnota'])
            vyhodnoceni[i] = dataXYmaxima[i]['hodnota']

        # ulozeni maxim
        df = pd.DataFrame(vyhodnoceni).T
        df.to_excel(file + '/vsechna_maxima.xlsx', header=name)
