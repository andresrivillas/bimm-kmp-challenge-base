import SwiftUI
import Shared

struct ContentView: View {
    @ObservedObject var viewModel: MainViewViewModel
    @State private var showContent = false
    var body: some View {
        VStack {
            
        }
        .onAppear {
                        viewModel.loadData()
                    }
        .frame(maxWidth: .infinity, maxHeight: .infinity, alignment: .top)
        .padding()
    }
}

