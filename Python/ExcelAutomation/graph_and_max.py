import matplotlib.pyplot as plt
import pandas as pd


class PlotGraph:
    def __init__(self, file):
        self.file = file

    def split_file_name(self):
        complete_file = self.file.split("/")

        just_file = "/".join(complete_file[:-1])
        name = complete_file[-1].split(".")
        just_name = name[0]
        return just_name, just_file

    def plot_1_graph_and_max(self):
        just_name, just_file = self.split_file_name()

        data = pd.read_excel(self.file)
        dataXY = pd.DataFrame(data, columns=['Time - Ascan', 'Amplitude - Ascan'])

        offset_x = dataXY['Time - Ascan'].__sub__(dataXY['Time - Ascan'][0])
        # print(new_data)
        try:
            read_file_max = pd.read_csv(just_file + "/" + just_name + 'maxima.csv', delimiter=';')
        except FileNotFoundError:
            print("soubor nenalezen")

        # print(read_file_max)
        plt.plot(offset_x, dataXY['Amplitude - Ascan'], linewidth=0.5, label='stred')
        plt.scatter(read_file_max['vzdalenost'], read_file_max['hodnota'], label='maxima', marker='x', c='red')
        plt.title('UT')
        plt.xlabel('mm')
        plt.ylabel('|A|')
        plt.legend()
        plt.grid(True)
        plt.show()

    def plot_1_graph(self):
        print("graf")
        #just_name, just_file = self.split_file_name()

        data = pd.read_excel(self.file)
        dataXY = pd.DataFrame(data, columns=['Time - Ascan', 'Amplitude - Ascan'])
        offset_x = dataXY['Time - Ascan'].__sub__(dataXY['Time - Ascan'][0])
        plt.plot(offset_x, dataXY['Amplitude - Ascan'], linewidth=0.5, label='stred')
        plt.title('UT')
        plt.xlabel('mm')
        plt.ylabel('|A|')
        plt.legend()
        plt.grid(True)
        plt.show()


