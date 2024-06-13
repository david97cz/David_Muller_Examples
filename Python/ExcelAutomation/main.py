import graph_and_max
import excel_operations_module
import protocol_module
import show_csv_data

import tkinter as tk
from tkinter import filedialog

root = tk.Tk()


class Main:
    def __init__(self, mySelection):
        self.mySelection = mySelection

    def open_dialog(self):
        file_path = filedialog.askopenfilename(title="Zvolte 1 soubor")
        root.withdraw()
        return file_path

    def main_switch(self):
        if self.mySelection == 1:
            print("vykreslemí 1 grafu a jeho maxim")
            file_path = self.open_dialog()
            graph1 = graph_and_max.PlotGraph(file_path)
            graph1.plot_1_graph_and_max()

        elif self.mySelection == 2:
            print("převedení dat z .xlsx do .txt")
            file_path = self.open_dialog()
            csv_covert = excel_operations_module.DataToCsv(file_path)
            csv_covert.convert_data()

        elif self.mySelection == 3:
            print("vykreslemí 1 grafu")
            file_path = self.open_dialog()
            graph1 = graph_and_max.PlotGraph(file_path)
            graph1.plot_1_graph()

        elif self.mySelection == 4:
            print("vykreslení všech grafů")

            protocol = protocol_module.Protocol(5)
            protocol.make_protocol()


        elif self.mySelection == 5:

            show_csv_graph = show_csv_data.Csv_viewer(60,230)
            show_csv_graph.show_graph()

        else:
            print("konec")

def main():

    print("Zvolte funkcionalitu")
    print("1 = vykreslemí 1 grafu a jeho maxim \n2 = převedení dat z .xlsx do .txt \n3 = vykreslemí 1 grafu"
          "\n4 = vykreslení všech grafů \n5 = graf porovnani 2 csv souboru")
    my_selection1 = int(input())

    vykresli = Main(my_selection1)
    vykresli.main_switch()

if __name__ == "__main__":
    main()

