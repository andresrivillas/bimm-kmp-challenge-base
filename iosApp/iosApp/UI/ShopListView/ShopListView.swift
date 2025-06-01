import SwiftUI
import Shared

struct ShopListView: View {
    @StateObject private var viewModel: ShopListViewViewModel
    
    init() {
        _viewModel = StateObject(wrappedValue: ShopListViewViewModel())
    }
    
    @State private var showContent = false
    var body: some View {
        NavigationStack {
            ScrollView(showsIndicators: false) {
                LazyVStack {
                    ForEach (viewModel.shops, id: \.name ) { shop in
                        listObject(shop: shop)
                            .onTapGesture {
                                viewModel.selectedShop = IdentifiableShop(shop: shop)
                            }
                    }
                }
            }
        }.onAppear {
            viewModel.loadData()
        }
        .sheet(item: $viewModel.selectedShop){ shop in
            ShopDetailView(shop: viewModel.selectedShop!)
                .presentationDetents([.fraction(0.85)])
        }
    }
}

struct listObject: View {
    
    var shop: Shop
    var body: some View {
        HStack(spacing: 10) {
            ImageView(imageUrl: shop.picture ?? "")
                .frame(width: 80, height: 80)
                .clipShape(RoundedRectangle(cornerRadius: 10))
            
            VStack(alignment: .leading, spacing: 6) {
                Text(shop.name ?? "")
                    .font(.headline)
                
                Text(shop.address ?? "")
                    .lineLimit(1)
                    .font(.subheadline)
                    .foregroundColor(.secondary)
                
                StarRatingView(rating: shop.rating as? Double ?? 0.0)
            }
            .frame(maxWidth: .infinity, alignment: .leading)
        }
        .frame(maxWidth: 360, minHeight: 100, maxHeight: 100, alignment: .leading)
        .padding()
        .background(Color(UIColor.secondarySystemBackground))
        .cornerRadius(10)
    }
}

#Preview {
    ShopListView()
}
