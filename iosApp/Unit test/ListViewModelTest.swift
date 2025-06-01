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
    
    func testInitialState() {
        XCTAssertTrue(viewModel.shops.isEmpty)
        XCTAssertNil(viewModel.selectedShop)
    }
    
    func testLoadData_ShouldUpdateShops() {
        shopRepository.shopList = ResponseBase<NSMutableArray>(value: [data], errors: nil, success: true)
        
        viewModel.loadData()
        
        XCTAssertEqual(viewModel.shops.count, 1)
        XCTAssertNil(viewModel.selectedShop)
        XCTAssertEqual(1, shopRepository.serviceCalledTimes)
    }
    
    func testLoadData_whenServiceReturnsError_setsErrorMessage() {
        shopRepository.shopList = ResponseBase<NSMutableArray>(value: nil, errors: "Error", success: false)
        let expectation = XCTestExpectation(description: "Load with service error")
        viewModel.loadData()

        DispatchQueue.main.asyncAfter(deadline: .now() + 0.1) {
            XCTAssertTrue(self.viewModel.shops.isEmpty)
            expectation.fulfill()
        }

        wait(for: [expectation], timeout: 1.0)
    }
    
    func testLoadData_withNilResult_setsEmptyShops() {
        shopRepository.shopList = ResponseBase<NSMutableArray>(value: nil, errors: nil, success: false)
        let expectation = XCTestExpectation(description: "Load shop data")
        viewModel.loadData()

        DispatchQueue.main.asyncAfter(deadline: .now() + 0.1) {
            XCTAssertTrue(self.viewModel.shops.isEmpty)
            expectation.fulfill()
        }

        wait(for: [expectation], timeout: 1.0)
    }
    
    func testSelectShop_setsSelectedShop() {
        let shop = IdentifiableShop(shop: data)
        
        viewModel.selectedShop = shop
        XCTAssertEqual(viewModel.selectedShop?.shop.name, "test")
    }
    
    func testLoadData_withEmptyResult_setsEmptyShops() {
        shopRepository.shopList = ResponseBase<NSMutableArray>(value: [], errors: nil, success: true)
        let expectation = XCTestExpectation(description: "Load shop data")
        viewModel.loadData()

        DispatchQueue.main.asyncAfter(deadline: .now() + 0.1) {
            XCTAssertTrue(self.viewModel.shops.isEmpty)
            expectation.fulfill()
        }

        wait(for: [expectation], timeout: 1.0)
    }

}
