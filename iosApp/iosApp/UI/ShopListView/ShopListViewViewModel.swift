//
//  MainViewViewModel.swift
//  iosApp
//
//  Created by Andres Rivillas on 29/05/25.
//

import Foundation
import Shared

class ShopListViewViewModel: ObservableObject {
    
    var repository: SakeShopRepository
    @Published var shops: [Shop] = []
    @Published var selectedShop: IdentifiableShop?
    
    init(repository: SakeShopRepository = SakeShopModule.shared.createShopRepository()) {
        self.repository = repository
    }
    
    func loadData() {
        repository.getShopList(){[weak self] result, error in
            guard let self = self else { return }
            shops = result?.value as? [Shop] ?? []
        }
    }
}

struct IdentifiableShop: Identifiable {
    let id = UUID()
    let shop: Shop
}

