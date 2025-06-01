//
//  Unit_test.swift
//  Unit test
//
//  Created by Andres Rivillas on 31/05/25.
//

import Combine
import Shared
import Foundation
import XCTest
@testable import KMP_Take_Home_Assignment

final class ListViewModelTest: XCTestCase {
    
    var cancellables: Set<AnyCancellable>!
    var shopRepository: MockSakeShopRepository!
    var data = Shop(name: "test", description: "Test", picture: "Test", rating: 3.2, address: "TEst", coordinates: nil, google_maps_link: "Test", website: "Test")
    var viewModel: ShopListViewViewModel!
    
    override func setUp() {
        super.setUp()
        shopRepository = MockSakeShopRepository()
        viewModel = ShopListViewViewModel(repository: shopRepository)
    }
    
    override func tearDown() {
        super.tearDown()
        shopRepository = nil
        cancellables = nil
    }
    
    func testLoadData_ShouldUpdateShops() {
        shopRepository.shopList = ResponseBase<NSMutableArray>(value: [data], errors: nil, success: true)
        
        viewModel.loadData()
        
        XCTAssertEqual(viewModel.shops.count, 1)
        XCTAssertNil(viewModel.selectedShop)
        XCTAssertEqual(1, shopRepository.serviceCalledTimes)
    }
}
